name::

Forces

description:: 

Выбор действующий сил и моментов на объект или обекты

html::
	<ul id="scMenu">
		<li id="scButtonRaw" scMenuActive="true">Исходный код</li>
		<li id="scButtonView" scMenuActive="false">Просмотр</li>
	</ul>
    <div id="scWindowRaw">
    	<textarea id="raw"></textarea><a id="conraw">Преобразовать SVG</a>
    </div>
    <div id="scWindowView"><div id="view"></div></div>



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
    width: 43%;
    text-align: center;
    margin: 0px;
}

#raw, #view{
	border: 1px solid #e6e6e6;
    width: 100%;
    min-height: 300px;
}
#scMenuRaw[scMenuActive=true] > ul +#scWindowRaw,
#scMenuView[scMenuActive=true] > ul + #scWindowView{
	display:block;
}
#scMenuRaw[scMenuActive=false] > ul + #scWindowRaw,
#scMenuView[scMenuActive=false] > ul + #scWindowView{
	display:none;
}




javascriptStudent::
console.log("student");

javascriptStudio::


function CONRaw(){setBlockHtml('view', getValueFild('raw').body.innerHTML)};
elementDOM.querySelector('#conraw').onclick = CONRaw;
elementDOM.querySelector('#scButtonRaw').onclick = function(){elementDOM.querySelector('#scWindowRaw').setAttribute('hidden', 'true'); elementDOM.querySelector('#scWindowView').setAttribute('hidden', 'false');};
elementDOM.querySelector('#scButtonRaw').onclick = function(){elementDOM.querySelector('#scWindowRaw').setAttribute('hidden', 'false'); elementDOM.querySelector('#scWindowView').setAttribute('hidden', 'true');};