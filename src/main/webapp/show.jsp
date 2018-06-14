<!DOCTYPE html>
<html lang="en">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
        <div class="container">
    <form method="post" action="insert">
        <center>
        <table  border="1" cellpadding="5"   class="table table-striped table-bordered table-hover table-condensed">
            <tr>
                <td>Id</td>
                <td><input type="text" placeholder="Enter Id" name="tid"></td>
            </tr>
            <tr>
                    <td>Name</td>
                    <td><input type="text" placeholder="Enter Name" name="tname"></td>
                </tr>
                <tr>
                        <td>Description</td>
                        <td><input type="text" placeholder="Enter the Description" name="tdes"></td>
                    </tr>
                    <tr>
                            <td>Price</td>
                            <td><input type="text"placeholder="Enter the Price" name="tprice"></td>
                        </tr>
                        
        </table>
    </center>
    <br>
    <br>
    <center>
        <input type="submit" value="Insert"/>
    </center>
    </form>
</div>
</body>
</html>