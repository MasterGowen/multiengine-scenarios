name::

Forces

description:: 

Выбор действующий сил и моментов на объект или обекты

html::

    <div class="container">
    <div>Test</div>
    </div>


css::
asdasdasd

javascriptStudent::


javascriptStudio::
elementDOM.querySelector('.windowRaw').innerHTML = '<h1>windowRaw</h1><textarea id="raw"></textarea>';
elementDOM.querySelector('.windowView').innerHTML = '<h1>windowView</h1><div id="view"></div>';
function CONRaw(){setBlockHtml('view', getValueFild('raw'))};
elementDOM.querySelector('.windowView').innerHTML = '<a href="javascript:CONRaw()">CON</a>';
