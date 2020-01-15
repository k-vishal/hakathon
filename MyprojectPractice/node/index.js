var express = require("express");
var mysql = require("mysql");

var app = express();

app.use(express.json());
var connection= mysql.createConnection({
    host:"localhost",
    database:"PuneDB",
    user:"root",
    password:"manager"
});
connection.connect();

 app.use(function (req,res,next){
     res.header("Access-Control-Allow-Origin","*");
     res.header("Access-Control-Allow-Methods","GET,POST,PUT,DELETE");
     res.header("Access-Control-Allow-Headers","Origin,X-Requested-With,Content-Type,Accept");
     next();
 
 })

app.get("/emps", (request, response)=>{
    var querytxt=`select * from Emp`;
    
    connection.query(querytxt, (err,res)=>{
        if(err==null)
        {
            response.send(JSON.stringify(res));
        }
        else{
            response.send(JSON.stringify(err));
        }
    });

} );

app.get("/emps/:No", (request, response)=>{
        var No= request.params.No;
        var querytxt=`select * from Emp where No=${No}`;
        
        connection.query(querytxt, (err, res)=>{
            if(err==null)
            {
                response.send(JSON.stringify(res));
            }
            else
            {
                response.send(JSON.stringify(err));
            }
        });
});

app.post("/emps", (request,response)=>{
        var No= request.body.No;
        var Name=request.body.Name;
        var Age= request.body.age;
        querytxt=`insert into Emp values( ${No}, '${Name}', ${Age})`;
        console.log(querytxt);
        connection.query(querytxt, (err, res)=>{
            if(err==null)
            {
                response.send(JSON.stringify(res));
            }
            else{
                response.send(JSON.stringify(err));
            }
        });
});

app.put("/emps/:No", (request, response)=>{
    var No= request.params.No;
    var Name= request.body.Name;
    var Age= request.body.age;
    var querytxt= `update Emp Set  Name='${Name}', age=${Age} where No=${No}`;
    console.log(querytxt);
    connection.query(querytxt, (err, result)=>{
        if(err==null)
        {
            response.send(JSON.stringify(result));
        }
        else
        {
            response.send(JSON.stringify(err));
        }
    });
});

app.delete("/emps/:No",(request,response)=>{
    
    var No=request.params.No;
   
    var querytxt= `delete from Emp where No=${No}`;
    console.log(querytxt);
    connection.query(querytxt, (err, res)=>{
        if(err==null)
        {
            response.send(JSON.stringify(res));
        }
        else{
            response.send(JSON.stringify(err));
        }
    });
});

app.listen(9090,()=>{
    console.log("server started");
});

