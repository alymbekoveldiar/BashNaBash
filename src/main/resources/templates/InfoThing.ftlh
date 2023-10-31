<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL</h1>
<hr>
<h4>Подробная информация </h4>
<img src="/images/${}" height="60px"/><br><br>
<b>Название товара: </b>${thing.type}<br>
<b>адресс товара: </b>${thing.address}<br>
<b>Описание товара: </b>${thing.ShortDescription}<br>
<b>Номер телефона : </b>${product.PhoneNumber}<br>
<b>Автор: </b>${product.author}<br>
<hr>
<form action="/product/delete/${product.id}" method="post">
    <input type="submit" value="Удалить товар"/>
</form>
</body>
</html>