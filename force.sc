name::

Forces

description:: 

Выбор действующий сил и моментов на объект или обекты

html::
    <div id="windowRaw"></div>
    <div id="windowView"></div>



css::
body{background:red};

javascriptStudent::
console.log("student");

javascriptStudio::
setBlockHtml('windowRaw','<h1>windowRaw</h1><textarea id="raw"></textarea><a id="conraw">CON</a>');
setBlockHtml('windowView','<h1>windowView</h1><div id="view"></div>');

function CONRaw(){setBlockHtml('view', getValueFild('raw').body.innerHTML)};
elementDOM.querySelector('#conraw').onclick = CONRaw;