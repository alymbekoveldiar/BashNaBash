<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL</h1><hr>
<h4>BashNaBash</h4>

<form action="/getAll" method="get">
    Поиск по названию вещей: <input type="text" name="title"><br>
    <input type="submit" value="Поиск"/>
</form>

<#list   as >
    <div>
        <p><b>${    .title}</b> ${product.price} руб. | <a href="/product/${product.id}">Подробнее...</a></p>
    </div>
<#else>
    <h3>Товаров нет</h3>
</#list>
<hr>
<h3>Создать новый товар</h3>
<form action="/product/create" method="post" enctype="multipart/form-data">
    Название товара: <input type="text" name="title"/><br><br>
    адресс товара: <input type="text" name="description"/><br><br>
    Описание товара: <input type="text" name="description"/><br><br>
    номер телефона товара: <input type="text" name="description"/><br><br>
    автор: <input type="text" name="description"/><br><br>
    Третья фотография: <input type="file" name="file3"/><br><br>
    <input type="submit" value="Добавить товар"/>
</form>
</body>
</html>
