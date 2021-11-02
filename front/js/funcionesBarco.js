$(document).ready(function(){
      $("#cargaActualiza").fadeOut();
      $("#volver").fadeOut();
  });


function traerInformacionBarcos(){
    $.ajax({
        url:"http://140.238.237.167:80/api/Boat/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            pintarRespuestaBarcos(respuesta);
        }
    });
}

function pintarRespuestaBarcos(respuesta){

    let myTable="<table>";
    for(i=0;i<respuesta.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+respuesta[i].name+"</td>";
        myTable+="<td>"+respuesta[i].brand+"</td>";
        myTable+="<td>"+respuesta[i].year+"</td>";
        myTable+="<td>"+respuesta[i].description+"</td>";
        myTable+="<td> <button onclick='borrarBarco("+respuesta[i].id+")'>Borrar</button></td>";
        myTable+="<td> <button onclick='llenarInformacionBote("+respuesta[i].id+")'>Actualizar</button></td>";
        myTable+="</tr>";
    }

    $(document).ready(function(){
        $("button").click(function(){
          $("#actualiza").fadeOut();
          $("#cargaActualiza").fadeIn();
          $("#volver").fadeIn();
        });
      });

    
    myTable+="</table>";
    $("#resultado2").html(myTable);
}
function guardarInformacionBarcos(){

    console.log();
    if($("#Bname").val() !== "" & $("#Bbrand").val() !== "" & $("#Byear").val() !== "" & $("#Bdescription").val() !== ""){
       
        let var1 = {
            name:$("#Bname").val(),
            brand:$("#Bbrand").val(),
            year:$("#Byear").val(),
            description:$("#Bdescription").val()
            };
          
            $.ajax({
            type:'POST',
            contentType: "application/json; charset=utf-8",
            dataType: 'JSON',
            data: JSON.stringify(var1),
            
            url:"http://140.238.237.167:80/api/Boat/save",
     
            success:function(response) {
                console.log(response);
            console.log("El Barco Se guardo correctamente");
            alert("El Barco \""+ $("#Bname").val() + "\" Se ha guardado Exitosamente");
            window.location.reload()
    
        },
        
        error: function(jqXHR, textStatus, errorThrown) {
              window.location.reload()
            alert("El Barco No se guardo correctamente");
    
    
        }
        });

    }else{

        alert("Para almacenar, Todos los campos de \"Barcos\" deben estar completamente diligenciados")
        return false
    }

    
}

function llenarInformacionBote(id){
    $.ajax({
        url:"http://140.238.237.167:80/api/Boat/"+id+"",
        type:"GET",
        datatype:"JSON",
        
        success:function(respuesta){
            console.log(respuesta);
            pintarRespuestaid(respuesta);
        }
    });
}

function pintarRespuestaid(respuesta){

    alert("Vas a modificar el barco \""+ respuesta.name + "\" ")
    
    $("#Bid").val(respuesta.id);
    $("#Bname").val(respuesta.name);
    $("#Bbrand").val(respuesta.brand);
    $("#Byear").val(respuesta.year);
    $("#Bdescription").val(respuesta.description);

}


function borrarBarco(id){
    let myData={
        id:id
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://140.238.237.167:80/api/Boat/"+id+"",
        type:"DELETE",
        data:dataToSend,
        contentType:"application/JSON; charset=utf-8",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            $("#resultado3").empty();
            window.location.reload()
            alert("El Barco se ha ELIMINADO Exitosamente")
        }
    });
    
}


function ActualizarInformacionBarcos(){

    console.log();
    if($("#Bname").val() !== "" & $("#Bbrand").val() !== "" & $("#Byear").val() !== "" & $("#Bdescription").val() !== ""){
       
        let var1 = {
            id:$("#Bid").val(),
            name:$("#Bname").val(),
            brand:$("#Bbrand").val(),
            year:$("#Byear").val(),
            description:$("#Bdescription").val()
            };
          
            $.ajax({
            type:'PUT',
            contentType: "application/json; charset=utf-8",
            dataType: 'JSON',
            data: JSON.stringify(var1),
            
            url:"http://140.238.237.167:80/api/Boat/update",
     
            success:function(response) {
                console.log(response);
            console.log("El Barco Se guardo correctamente");
            alert("El Barco \""+ $("#Bname").val() + "\" Se ha Actualizado Exitosamente");
            window.location.reload();
    
        },
        
        error: function(jqXHR, textStatus, errorThrown) {
              window.location.reload()
            alert("El Barco No se guardo correctamente");
    
    
        }
        });

    }else{

        alert("Para Actualizar, Todos los campos de \"Barcos\" deben estar completamente diligenciados")
        return false
    }

    
}

function volver(){
    alert("los cambios no se guardaron")
    window.location.reload()
}