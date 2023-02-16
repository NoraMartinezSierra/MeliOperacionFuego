# MeliOperacionFuego
Mercado libre Evaluación para desarrolladores backend

se crea repositorio en github
se sube proyecto en AWS
la url del apigateway es esta
https://p3lc5ye4x9.execute-api.us-east-1.amazonaws.com/prod/topsecret
la url del servidor 
http://operacionf.us-east-1.elasticbeanstalk.com/topsecret
se crea servicio que recibe la lista de satelites
[
{
"name": "kenobi",
"distance": 100.0,
"message": ["este", "", "", "mensaje", ""]
}, {
"name": "skywalker",
"distance": 115.5,
"message": ["", "es", "", "", "secreto"]
},
{
"name": "sato",
"distance": 142.7,
"message": ["este", "", "un", "", ""]
}
]

y retorn esta respuesta
{
    "exitosa": true,
    "estado": 200,
    "mensaje": "Post exitoso",
    "documentos": {
        "data": {
            "mensaje": "este es un mensaje secreto",
            "posicionDto": {
                "x": 324.857275,
                "y": -67.27214999999998
            }
        }
    }
}

para el nivel 

recibe un satelite y retorna el mensaje que logra capturar

[
{
"name": "sato",
"distance": 142.7,
"message": ["este", "", "un", "", ""]
}
]

y esta es la respuesta

{
    "exitosa": true,
    "estado": 200,
    "mensaje": "Post exitoso",
    "documentos": {
        "data": {
            "mensaje": "este un",
            "posicionDto": null
        }
    }
}

