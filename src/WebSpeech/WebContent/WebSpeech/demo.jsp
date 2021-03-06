<%@ page language="java"  contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
pageContext.setAttribute("basePath", basePath);
System.out.println(basePath);
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<script type='text/javascript' src='${basePath}WebSpeech/WebSpeech.js'></script>
</head>
<body>
<div>
<form>
<input type='button' id='buttonSPR' onclick='spr()' value='Speak' />
<input type='button' onclick='stop()' value='Stop' />
<input type='button' onclick='saveMp3()' value='Save to MP3' />
<input type='button' onclick='saveOgg()' value='Save to OGG' />
<input type='button' onclick='showSymbols()' value='Show Phonetic Symbols' />
<br />
Language:<select id='voice' onchange='setVoice()'>
<option value='EkhoMandarin'>Mandarin (Yali)</option>
<option value='EkhoCantonese'>Cantonese (Wong)</option>
<!--  <option value='EkhoEnglish'>English</option>-->
<option value='af'>Afrikaans</option>
<option value='bs'>Bosnian</option>
<option value='ca'>Catalan</option>
<option value='cs'>Czech</option>
<option value='cy'>Welsh</option>
<option value='da'>Danish</option>
<option value='de'>German</option>
<option value='el'>Greek</option>
<option value='en'>English</option>
<option value='en-sc'>English (Scottish)</option>
<option value='en-uk'>English (UK)</option>
<option value='en-uk-north'>English (Lancashire)</option>
<option value='en-uk-rp'>English (uk-rp)</option>
<option value='en-uk-wmids'>English (wmids)</option>
<option value='en-us'>English (US)</option>
<option value='en-wi'>English (West Indies)</option>
<option value='eo'>Esperanto</option>
<option value='es'>Spanish</option>
<option value='es-la'>Spanish (Latin American)</option>
<option value='fi'>Finnish</option>
<option value='fr'>French</option>
<option value='fr-be'>French (Belgium)</option>
<option value='grc'>Greek (ancient)</option>
<option value='hi'>Hindi</option>
<option value='hr'>Croatian</option>
<option value='hu'>Hungarian</option>
<option value='hy'>Armenian</option>
<option value='hy-west'>Armenian (west)</option>
<option value='id'>Indonesian</option>
<option value='is'>Icelandic</option>
<option value='it'>Italian</option>
<option value='jbo'>Lojjban</option>
<option value='ku'>Kurdish</option>
<option value='la'>Latin</option>
<option value='lv'>Latvian</option>
<option value='mk'>Macedonian</option>
<option value='nci'>Nahuatl (classical)</option>
<option value='nl'>Dutch</option>
<option value='no'>Norwegian</option>
<option value='pap'>Papiamento</option>
<option value='pl'>Polish</option>
<option value='pt'>Brazil</option>
<option value='pt-pt'>Portugal</option>
<option value='ro'>Romanian</option>
<option value='ru'>Russian</option>
<option value='sk'>Slovak</option>
<option value='sq'>Albanian</option>
<option value='sr'>Serbian</option>
<option value='sv'>Swedish</option>
<option value='sw'>Swahihi</option>
<option value='ta'>Tamil</option>
<option value='tr'>Turkish</option>
<option value='vi'>Vietnam</option>
<option value='zh'>Mandarin (eSpeak)</option>
<option value='zh-yue'>Cantonese (eSpeak)</option>
</select>
Variant:<select id='variant' disabled='disabled' onchange='setVoice()'>
<option value=''>normal</option>
<option value='f1'>female 1</option>
<option value='f2'>female 2</option>
<option value='f3'>female 3</option>
<option value='f4'>female 4</option>
<option value='m1'>male 1</option>
<option value='m2'>male 2</option>
<option value='m3'>male 3</option>
<option value='m4'>male 4</option>
<option value='m5'>male 5</option>
<option value='m6'>male 6</option>
<option value='m7'>male 7</option>
<option value='klatt'>klatt 1</option>
<option value='klatt2'>klatt 2</option>
<option value='klatt3'>klatt 3</option>
<!--<option value='croak'>croak</option>
<option value='wisper'>wisper</option>-->
</select>
<br />
Speed Delta(-50..100):<input type='text' id='speedDelta' onblur='setSpeedDelta()' size='3' value='0' />
Pitch Delta(-100..100):<input type='text' id='pitchDelta' onblur='setPitchDelta()' size='3' value='0' />
Volume Delta(-100..100):<input type='text' id='volumeDelta' onblur='setVolumeDelta()' size='3' value='0' />
<br />
<textarea id='text' cols='80' rows='5'></textarea>
<div id='phonSymbol'></div>
</form>
</div>
<script type='text/javascript'>
WebSpeech.server = "<%=basePath%>speak"
</script>
<script type='text/javascript'>
  function setSpeedDelta() {
    var speedDelta = document.getElementById('speedDelta').value;
    speedDelta = WebSpeech.setSpeedDelta(speedDelta);
    document.getElementById('speedDelta').value = speedDelta;
  }

  function setPitchDelta() {
    var pitchDelta = document.getElementById('pitchDelta').value;
    pitchDelta = WebSpeech.setPitchDelta(pitchDelta);
    document.getElementById('pitchDelta').value = pitchDelta;
  }

  function setVolumeDelta() {
    var volumeDelta = document.getElementById('volumeDelta').value;
    volumeDelta = WebSpeech.setVolumeDelta(volumeDelta);
    document.getElementById('volumeDelta').value = volumeDelta;
  }

  function setVoice() {
    var voice = document.getElementById('voice').value;
    if (voice === 'EkhoCantonese' || voice === 'EkhoMandarin') {
      document.getElementById('variant').disabled = true;
    } else {
      var variant = document.getElementById('variant');
      variant.disabled = false;
      if (variant.value !== 'normal') {
        voice += '+' + variant.value;
      }
    }
    WebSpeech.setVoice(voice);
  }

  // speak pause or resume
  function spr() {
    setVoice();
    var value = document.getElementById('buttonSPR').value;
    if (value === 'Speak') {
	  var textvalue = document.getElementById('text').value;
      WebSpeech.speak(textvalue);
      document.getElementById('buttonSPR').value = 'Pause';
      WebSpeech.onfinish = function () {
        document.getElementById('buttonSPR').value = 'Speak';
      }
    } else if (value === 'Pause') {
      WebSpeech.pause();
      document.getElementById('buttonSPR').value = 'Resume';
    } else if (value === 'Resume') {
      WebSpeech.resume();
      document.getElementById('buttonSPR').value = 'Pause';
    }
  }

  function stop() {
    WebSpeech.stop();
    document.getElementById('buttonSPR').value = 'Speak';
  }

  function saveMp3() {
    setVoice();
    WebSpeech.saveMp3(document.getElementById('text').value);
  }

  function saveOgg() {
    setVoice();
    WebSpeech.saveOgg(document.getElementById('text').value);
  }

  var getSymbolsCallback = function (success, symbols) {
    if (success) {
      var text = document.getElementById('text').value;
      var symbolArray = symbols.split(' ');
      if (symbolArray[symbolArray.length - 1] == '') {
        symbolArray.pop();
      }
      var len1 = text.length;
      var len2 = symbolArray.length;
      var output = '';
      // I cannot use text.length === symbolArray.length, it's very strange
      // Maybe it's a bug of Firefox
      if (len1 === len2 && document.getElementById('voice').value.match(/^Ekho/)) {
        for (var i = 0; i < text.length; ++i) {
          output += '<b style="font-size:150%">' + text.charAt(i) + '</b>';
          if (symbolArray[i].match(/^[a-z]+[0-9]/)) {
            output += symbolArray[i];
          }
          output += ' ';
        }
      } else {
        output += '<b style="font-size:150%">' + text + '</b><br />';
        for (var i in symbolArray) {
          if ((! document.getElementById('voice').value.match(/^Ekho/)) ||
              symbolArray[i].match(/^[a-z]+[0-9]$/)) {
            output += symbolArray[i];
          }
          output += ' ';
        }
      }
      document.getElementById('phonSymbol').innerHTML =
          "<div style='border-style:solid;border-width:1px;'>" + output + '</div>';
    }
  }

  function showSymbols() {
    setVoice();
    var text = document.getElementById('text').value;
    WebSpeech.getPhonSymbols(text, getSymbolsCallback);
  }
</script>
</body></html>
