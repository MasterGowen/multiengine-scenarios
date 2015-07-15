name::

Forces

description:: 

Выбор действующий сил и моментов на объект или обекты

html::
<div class="tabs">
    <input id="tab1" type="radio" name="tabs" checked>
    <label for="tab1" title="Вкладка 1">Вкладка 1</label>
 
    <input id="tab2" type="radio" name="tabs">
    <label for="tab2" title="Вкладка 2">Вкладка 2</label>
 
    <input id="tab3" type="radio" name="tabs">
    <label for="tab3" title="Вкладка 3">Вкладка 3</label>
 
    <input id="tab4" type="radio" name="tabs">
    <label for="tab4" title="Вкладка 4">Вкладка 4</label>
 
    <section id="content1">
        <p>
        Здесь размещаете любое содержание....
        </p>
    </section>  
    <section id="content2">
        <p>
          Здесь размещаете любое содержание....
        </p>
    </section> 
    <section id="content3">
        <p>
          Здесь размещаете любое содержание....
        </p>
    </section> 
    <section id="content4">
        <p>
          Здесь размещаете любое содержание....
        </p>
    </section>    
</div>
    <div id="windowRaw"></div>
    <div id="windowView"></div>



css::
/* Базовый контейнер табов */
.tabs {
  min-width: 320px;
  max-width: 800px;
  padding: 0px;
  margin: 0 auto; 
}
/* стили секций с содержанием */
section {
  display: none;
  padding: 15px;
  background: #fff;
  border: 1px solid #ddd;
}
.tabs input {
  display: none;
}
/* стили вкладок (табов) */
.tabs label {
  display: inline-block;
  margin: 0 0 -1px;
  padding: 15px 25px;
  font-weight: 600;
  text-align: center;
  color: #aaa;
  border: 1px solid #ddd;
  background: #f1f1f1;
  border-radius: 3px 3px 0 0;
}
/* шрифт-иконки от Font Awesome в формате Unicode */
.tabs label:before {
  font-family: fontawesome;
  font-weight: normal;
  margin-right: 10px;
}
.tabs label[for*="1"]:before {
  content: "\f19a";
}
.tabs label[for*="2"]:before {
  content: "\f17a";
}
.tabs label[for*="3"]:before {
  content: "\f13b";
}
.tabs label[for*="4"]:before {
  content: "\f13c";
}
/* изменения стиля заголовков вкладок при наведении */
.tabs label:hover {
  color: #888;
  cursor: pointer;
}
/* стили для активной вкладки */
.tabs input:checked + label {
  color: #555;
  border: 1px solid #ddd;
  border-top: 1px solid #009933;
  border-bottom: 1px solid #fff;
  background: #fff;
}
/* активация секций с помощью переключателя :checked */
#tab1:checked ~ #content1,
#tab2:checked ~ #content2,
#tab3:checked ~ #content3,
#tab4:checked ~ #content4 {
  display: block;
}
/* медиа запросы для различных типов носителей */  
@media screen and (max-width: 680px) {
  .tabs label {
    font-size: 0;
  }
 
  .tabs label:before {
    margin: 0;
    font-size: 18px;
  }
}
@media screen and (max-width: 400px) {
  .tabs label {
    padding: 15px;
  }
}

javascriptStudent::
console.log("student");

javascriptStudio::
setBlockHtml('windowRaw','<h1>windowRaw</h1><textarea id="raw"></textarea><a id="conraw">CON</a>');
setBlockHtml('windowView','<h1>windowView</h1><div id="view"></div>');

function CONRaw(){setBlockHtml('view', getValueFild('raw').body.innerHTML)};
elementDOM.querySelector('#conraw').onclick = CONRaw;