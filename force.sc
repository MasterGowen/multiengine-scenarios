name::

Forces

description:: 

Выбор действующий сил и моментов на объект или обекты

html::
<ul class="tabs">
  <li><a href="#one">1</a></li>
  <li><a href="#two">2</a></li>
  <li><a href="#three">3</a></li>
  <li><a href="#four">4</a></li>
  <li><a href="#five">5</a></li>
</ul>
<div class="tabs-content">
<ul>
  <li id="one">Содержимое 1-й вкладки</li>
  <li id="two">Содержимое 2-й вкладки</li>
  <li id="three">Содержимое 3-й вкладки</li>
  <li id="four">Содержимое 4-й вкладки</li>
  <li id="five">Содержимое 5-й вкладки</li>
</ul>
</div>
    <div id="windowRaw"></div>
    <div id="windowView"></div>



css::
.tabs-content {
    width:960px;
    height:300px;
    overflow:hidden;
}
.tabs-content ul {
    list-style: none
    /* Эти 3 линии для Opera */
    height: 320px;
    overflow: scroll;
    overflow-y: hidden;
}
.tabs-content ul li {
    width:960px;
    height:300px;
}


javascriptStudent::
console.log("student");

javascriptStudio::
setBlockHtml('windowRaw','<h1>windowRaw</h1><textarea id="raw"></textarea><a id="conraw">CON</a>');
setBlockHtml('windowView','<h1>windowView</h1><div id="view"></div>');

function CONRaw(){setBlockHtml('view', getValueFild('raw').body.innerHTML)};
elementDOM.querySelector('#conraw').onclick = CONRaw;