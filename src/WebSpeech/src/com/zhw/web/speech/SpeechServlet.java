
package com.zhw.web.speech; 

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder; 


@SuppressWarnings("restriction")
public class SpeechServlet extends HttpServlet { 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 158048527606024L;
	
	static{
		System.out.println("SpeechServlet inited...");
	}
	@Override 
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException 
	{ 
		System.out.println("SpeechServlet service()");
		req.setCharacterEncoding("utf-8"); 
//		resp.setContentType("text/html;charset=utf-8"); 
		resp.setContentType("audio/mpeg");
		
		
		//每个表单域中数据会封装到一个对应的FileItem对象上 
		try { 
			ServletContext sctx = getServletContext(); 
			String path = sctx.getRealPath("/temp"); 
			System.out.println(path); 
			File filepath = new File(path); 
			if(!filepath.exists()){
				filepath.mkdirs();
			}
			//获得文件名 
			//voice=EkhoMandarin&speedDelta=0&pitchDelta=0&volumeDelta=0&text=text
			//Specified language or voice. ('Cantonese', 'Mandarin', 'Toisanese', 'Hakka', 'Tibetan', 'Ngangien' and 'Hangul' are available now. Mandarin is the default language.)
			String voice = req.getParameter("voice");
			String voicestr = "";
			if(voice!=null && voice.length()>0){
				voicestr = " -v "+voice;
			}
	        //-s, --speed=SPEED
	        //Set delta speed. Value range from -50 to 300 (percent)
			String speedDelta = req.getParameter("speedDelta");
			String speed = "";
			if(speedDelta!=null && speedDelta.length()>0 && 
					Integer.valueOf(speedDelta)>-50 && Integer.valueOf(speedDelta)<300){
				speed = " -s "+speedDelta;
			}
			//-p, --pitch=PITCH_DELTA
	        //Set delta pitch. Value range from -100 to 100 (percent)
			String pitchDelta = req.getParameter("pitchDelta");
			String pitch = "";
			if(pitchDelta!=null && pitchDelta.length()>0 && 
					Integer.valueOf(pitchDelta)>-100 && Integer.valueOf(pitchDelta)<100){
				pitch = " -p "+pitchDelta;
			}
	        //-a, --volume=VOLUME_DELTA
	        //Set delta volume. Value range from -100 to 100 (percent)
			String volumeDelta = req.getParameter("volumeDelta");
			String volume = "";
			if(volumeDelta!=null && volumeDelta.length()>0 && 
					Integer.valueOf(volumeDelta)>-100 && Integer.valueOf(volumeDelta)<100){
				volume = " -a "+volumeDelta;
			}
			String text = req.getParameter("text");
			if(text==null || text.length()<=0){
				return;
			}
			String md5str = EncoderByMd5(text);
			md5str = md5str.replaceAll("/", "_");
			String fileName = path+File.separator+md5str+voice+speedDelta+pitchDelta+volumeDelta+".mp3";
			//String cmd = "ekho -s $speed -p $pitch -a $volume -v $voice -o $filepath \""+text+"\" ";
			String cmd = "ekho "+speed+pitch+volume+voicestr+" -o "+fileName+" \""+text+"\" ";
			System.out.println(cmd);
			File file = new File(fileName);
			if(!file.exists()){ 
				//text to speech
				Runtime run = Runtime.getRuntime();
				Process process = run.exec(cmd);
				InputStream in = process.getInputStream();
				StringBuffer sb = new StringBuffer();
	            while (in.read() != -1) {
	            	sb.append(in.read());
	            }
	            in.close();
	            process.waitFor();
			} 
			//读取文件信息
			if(file.exists()){
				resp.setContentLength(new Long(file.length()).intValue());
				byte[] bs = FileUtil.getContent(fileName);
				ServletOutputStream bo = resp.getOutputStream();
				bo.write(bs);
				bo.flush();
			}
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		} 
	
	} 
	
	/**
	 * 利用MD5进行加密 @param str 待加密的字符串 @return 加密后的字符串 @throws
	 * NoSuchAlgorithmException 没有这种产生消息摘要的算法 @throws
	 * UnsupportedEncodingException
	 */
	public String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return EncoderByMd5(str,"MD5");
	}
	public String EncoderBySha256(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return EncoderByMd5(str,"SHA-256");
	}
	public String EncoderBySha512(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return EncoderByMd5(str,"SHA-512");
	}
	public String EncoderByMd5(String str,String type) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// 确定计算方法
		MessageDigest md5 = MessageDigest.getInstance(type);
		BASE64Encoder base64en = new BASE64Encoder();
		// 加密后的字符串
		String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
		return newstr;
	}
} 