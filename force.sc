name::

Forces

description:: 

Выбор действующий сил и моментов на объект или обекты

html::
	<ul id="scMenu">
		<li id="scButtonRaw" scMenuActive="true">Исходный код</li>
        <li id="conraw">Преобразовать SVG</li>
		<li id="scButtonView" scMenuActive="false">Просмотр</li>
	</ul>
    <div id="scWindowRaw">
    	<textarea id="raw"></textarea>
    </div>
    <div id="scWindowView" hidden='true'><div id="view"></div></div>



css::
#scMenu{
	margin: 10px auto;
    display: block;
    width: 350px;
}

#scMenu li {
    border: 1px solid #e6e6e6;
    padding: 10px;
    display: inline-block;
    width: 28%;
    text-align: center;
    margin: 0px;
}
#scMenu li[scMenuActive=true]{
    background:#e6e6e6;
}

#raw, #view{
	border: 1px solid #e6e6e6;
    width: 100%;
    min-height: 570px;
}




javascriptStudent::
console.log("student");

javascriptStudio::


function CONRaw(){setBlockHtml('view', getValueFild('raw').body.innerHTML)};
elementDOM.querySelector('#conraw').onclick = CONRaw;
elementDOM.querySelector('#scButtonView').onclick = function(){elementDOM.querySelector('#scWindowRaw').setAttribute('hidden', 'true'); elementDOM.querySelector('#scWindowView').removeAttribute('hidden');};
elementDOM.querySelector('#scButtonRaw').onclick = function(){elementDOM.querySelector('#scWindowRaw').removeAttribute('hidden'); elementDOM.querySelector('#scWindowView').setAttribute('hidden', 'true');};