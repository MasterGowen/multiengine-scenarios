name::

Forces

description:: 

Выбор действующий сил и моментов на объект или обекты

html::
	<ul id="scMenu">
		<li id="scMenuRaw">Исходный код</li>
		<li id="scMenuView">Просмотр</li>
	</ul>
    <div id="scWindowRaw"></div>
    <div id="scWindowView"></div>



css::



javascriptStudent::
console.log("student");

javascriptStudio::
setBlockHtml('scWindowRaw','<h1>windowRaw</h1><textarea id="raw"></textarea><a id="conraw">CON</a>');
setBlockHtml('scWindowView','<h1>windowView</h1><div id="view"></div>');

function CONRaw(){setBlockHtml('view', getValueFild('raw').body.innerHTML)};
elementDOM.querySelector('#conraw').onclick = CONRaw;