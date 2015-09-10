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
    <div id="scWindowView" hidden='true'>
    	<div id="view"></div>
    </div>



css::
/*костыл*/
[class*="view-"] .modal-lg.modal-editor .modal-content {
  height: 609px;}
[class*="view-"] .modal-window .editor-with-buttons.wrapper-comp-settings .list-input.settings-list {
  height: 549px;
}
 /*конец*/ 
 .step-one{display:none}

 .scEditButtonView{
    background: #FFD700 none repeat scroll 0% 0%;
    text-align: center;
    display: inline-block;
    padding: 4px 12px;
    margin: 11px 1px;
    cursor: pointer;
 }
  .scEditButtonView:hover{
 background: #FFB400;
}

.scEditButtonConv{
    background: #FF4800 none repeat scroll 0% 0%;
    text-align: center;
    display: inline-block;
    padding: 4px 12px;
    margin: 11px 1px;
    cursor: pointer;
    color: #FFFFFF;
 }

.scEditButtonConv:hover{
 background: #D53C00;
}

#allAnswers{
    display: -webkit-box;
}

#scMenu{
    margin: 10px auto;
    display: block;
    width: 620px;
}

#scMenu li {
    border: 1px solid #e6e6e6;
    padding: 10px;
    display: inline-block;
    width: 28%;
    text-align: center;
    margin: 0px;
    cursor: pointer;
}

#scMenu li:hover {
    border-color:gold;
}

#scMenu li[scMenuActive=true]:hover {
    border-color:#e6e6e6;
}

#scMenu li[scMenuActive=true]{
    background:#e6e6e6;
}

#raw, #view{
    border: 1px solid #e6e6e6;
    width: 100%;
    min-height: 300px;
}

.cell {
    border: 1px solid white;
    min-width: 100px;
    cursor: pointer;
    background: #D8E6F3;
}

.first{
	background: rgb(170, 222, 226);
	border: 1px solid white;
    background: #AFCDE7;
    min-width: 100px;
}

.dragAnswer[contenteditable=true], .fixAnswer[contenteditable=true]{
    background: white;
    border: 1px solid grey;
    padding: 2px 10px;
    display: inline-block;
    cursor: text;
}

.dragAnswer{
	border: 1px dashed rgb(163, 55, 55);
    cursor: move;
    margin: 5px;
    padding: 2px 10px;
    display: inline-block;
    position: relative;
    min-height: 15px;
    min-width: 30px;
}

.fixAnswer{
    border: 1px dashed white;
    margin: 5px;
    position: relative;
    min-height: 15px;
    min-width: 30px;
}

.deleteItemButton {
    background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAACbklEQVR42qWTXUiTURjH/+/XPt5tbII1lokoSSAV7Cqo0UU5RkVpTIOiUqEb+6DvKKEcBhZhHxfSboS0Dy9aiyxK1rSLWNHdbkQQw5KMZUnb2N53be+7d529OpnOLqLn5jz/85zzO895nnMo/KdRxYIHbpmB2giwn8jfy9bqKoAnUWBSBM6VADRAd295+eU16TTaEok3P4FGMp1aCOttwNBjk8k5odXi1Nzc9QzQsQhggEs9Fkv3vtZWKidJ+DgwgOPJ5MgvYG8+vgp40Wc01m9qaQHFcXjW35+7EIt1ZIEbeYDOBcS8zc1azmZTj8vGYgj5/TgpCKP5BV6DYcdmtxuMxaLGpUgE7T5fOgBYClc4dNFsvn/C6WRpnp+HJBL4EAio/haXC4zJpPqKKKI3GJRvxuNtRD4qLqL7NM8Pnnc4NAWIIgjqSBsMi5t7QqHMXVE8SKS/pAvEdrVrtU+v2O36AqRg+c3XwuGUN51uIvL1im0kZrQC714aDPbqurolgS/j49gjCOHvwDYikysBTGsJeZDjHBurqgBS7SVGujM2PY0DkhSaIZmSmUQxwFQDDPtZdus6qxUUw6iTciajjqxGo465bBafZmfhluX3U8DOPEQF6IDbYzR9prKsjFSMVhdnyImH4/Efef+h2bxaU8hIUTATjWKDotwhr+ysCtADnucs2+nUE4+ikJJlNInit2GgXq0sMOLj+Qo9y5I0cgimUmiU5S4C6Cx+yp4HNH11N8NQDZL0+e385qmFcM12AhniuOpX2WzuiKJ0kct5SrpAkj9WCxydABqI/LqsQ5XryX+YBPoU4N7f2vjP9gfr3dEZbh82JAAAAABJRU5ErkJggg==);
    background-size: cover;
    position: absolute;
    width: 12px;
    height: 12px;
    top: -6px;
    right: -6px;
    cursor: pointer;
}

.first:before, 
.cell:before {
  content: "+";
  margin: 0 auto;
  display: block;
  width: 9px;
  color: gray;
}

.first:before {
  cursor: pointer;
}



javascriptStudent::
console.log("student");

javascriptStudio::
elementDOM.querySelector('#scButtonView').onclick = function(){
    elementDOM.querySelector('#scButtonRaw').setAttribute('scMenuActive', 'false');
    elementDOM.querySelector('#scButtonView').setAttribute('scMenuActive', 'true');
    elementDOM.querySelector('#scWindowRaw').setAttribute('hidden', 'true'); 
    elementDOM.querySelector('#scWindowView').removeAttribute('hidden');
};
elementDOM.querySelector('#scButtonRaw').onclick = function(){
    elementDOM.querySelector('#scButtonRaw').setAttribute('scMenuActive', 'true');
    elementDOM.querySelector('#scButtonView').setAttribute('scMenuActive', 'false');
    elementDOM.querySelector('#scWindowRaw').removeAttribute('hidden');
    elementDOM.querySelector('#scWindowView').setAttribute('hidden', 'true');
};