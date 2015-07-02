name::

Второй сценарий

description:: 

Просто второй сценарий

html::

<head>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>

</head>
<body>
    <table border=1 class='dragAnswer' id="dragTable" >
        <button class="" onclick="add_row()">Add answerPlace</button>
        <button class="" onclick="add_column()">Add column</button>
        
        <tbody>
            <tr class="col">
                    <td class=""><p> </p></td>
                    <td class="col"><p contenteditable="true">Параметр</p></td>
            </tr>
            <tr class="answerPlace row">
                <td class=""><p contenteditable="true">Параметр</p></td>
                <td class="cell" id="TC4bA"> <button class="add-item-button" onclick="add_item('TC4bA')">+</button></td>

        </tbody>
    </table>

<div class="answerPlace" id="dragAnswers" >
            <div class="answer" id="v1">Вариант 1 </div>
            <div class="answer" id="v2">Вариант 2</div>
            <div class="answer" id="v3">Вариант 3</div>
            <div class="answer" id="v4">Вариант 4</div>
            <div class="answer" id="v5">Вариант 5</div>
            <div class="answer" id="v6">Вариант 6</div>
            <div class="answer" id="v7">Вариант 87</div>
    </div>

css::

.add-item-button{
 width: 100%;
}
.cell
{
vertical-align:top;
  min-width: 100px;
}

table {
    font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
    font-size: 14px;
    border-collapse: collapse;
    text-align: center;
}
    tr, td:first-child {
    background: #AFCDE7;
    color: white;
    padding: 10px 20px;
}
    tr, td {
    /*border-style: solid;*/
    border-width: 0 1px 1px 0;
    border-color: white;
}
    td {
    background: #D8E6F3;
    vertical-align:top;
        padding:.5em;
        cursor: move;
        width: 100px;
        height: 50px;
}
    tr:first-child, td:first-child {
    text-align: left;
}
    table {
        /*width: 800px;
        height: 400px;*/
    }

    .answer {
        padding: 5px;
        cursor: move;
        border: 1px solid grey;
        margin:2px;
        max-width: 400px;
        min-width: 100px;
    }
    #dragAnswers {
        border: 1px solid grey;
        max-width: 400px;
        min-width: 100px;
        padding: 1em;
    }
    

javascriptStudent::
alert('javascriptStudent');
alert('javascriptStudent test');
//$('#testdiv').html('Opapapapapap!')

javascriptStudio::
alert('javascriptStudio');
alert('javascriptStudent tets');