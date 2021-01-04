
/*Inicio click sobre sala */
function show() {
    alert("Ir a la sala");
 }
 


/*Formulario cambio de imagen sala*/

u.addEventListener("change",()=>{
p.setAttribute("src","images/plantas/"+u.selectedOptions[0].value+".svg")
});


/*Formulario secciones desplegables*/

/*
function mostrar(valor){
    
    if(valor==1){
        document.getElementById('ocultar1').style.display='block';
    }else if(valor==2){
        document.getElementById('ocultar2').style.display ='block';
    }else if(valor==3){
        document.getElementById('ocultar3').style.display ='block';
    }else if(valor==4){
        document.getElementById('ocultar4').style.display ='block';
    }else if(valor==5){
        document.getElementById('ocultar5').style.display ='block';
    } else {
        document.getElementById('ocultar6').style.display ='block';
    }
}*/

/*function mostrarOcultar() {
    var x = document.getElementById("ocultar1");
    if (x.style.display === "none") {
      x.style.display = "block";
    } else {
      x.style.display = "none";
    }
}*/


function mostrarOcultar(valor){
    if(valor==1){
        var icon = document.querySelector('#icon1');
        var x = document.querySelector('#ocultar1');
    }else if(valor==2){
        var icon = document.querySelector('#icon2');
        var x = document.querySelector('#ocultar2');
    }else if(valor==3){
        var icon = document.querySelector('#icon3');
        var x = document.querySelector('#ocultar3');
    }else if(valor==4){
        var icon = document.querySelector('#icon4');
        var x = document.querySelector('#ocultar4');
    }else if(valor==5){
        var icon = document.querySelector('#icon5');
        var x = document.querySelector('#ocultar5');
    }else if(valor==6){
        var icon = document.querySelector('#icon6');
        var x = document.querySelector('#ocultar6');
    }else if(valor==7){
        var icon = document.querySelector('#icon7');
        var x = document.querySelector('#ocultar7');
    } else if(valor==8){
        var icon = document.querySelector('#icon8');
        var x = document.querySelector('#ocultar8');
    }
    
    icon.classList.toggle('fa-minus-circle');
    icon.classList.toggle('fa-plus-circle');
    
    if (x.style.display === "block") {
        x.style.display = "none";
    } else {
        x.style.display = "block";
    }
    
}

/*
document.querySelector('i').addEventListener('click', ()=>{
    
    var icon = document.querySelector('i');
    icon.classList.toggle('fa-minus-circle');
    icon.classList.toggle('fa-plus-circle');
    
    var x = document.querySelector('.ocultar');
    if (x.style.display === "block") {
        x.style.display = "none";
    } else {
        x.style.display = "block";
    }
    
})*/
    

/*Sidebar desplegable (Revisar!!!!) */

$("#ocultaMenu").click(function(e) {

    $("#wrapper").toggleClass("toggled");
    e.preventDefault();
});

/*Alerta nuevo ingreso - derivar a formulario*/

function agregar(valor){
    var link = document.getElementById('ir');
  if(valor=='pintura'){
    link.href="formularioPintura.html";
  }else if(valor=="escultura"){
    link.href="formularioEscultura.html";
  }else if(valor=="textil"){
    link.href="formularioTextil.html";
  }
}
/*Ficha tecnica popover inevntario */
var popover = new bootstrap.Popover(document.querySelector('.example-popover'), {
    container: 'body'
  })
/* Estado de conservación - Panel de información */

function e(x){
    
    var p= document.querySelector('#nodo');
    
    if(x==1){
        p.innerHTML="<span>Estado muy bueno</span></br> El bien no presenta síntomas de deterioros y alteraciones visibles, y en el caso de que se observasen algunas, estas corresponderían a los procesos naturales de la transformación de la materia que afectan su forma, estructura y contenido simbólico o textual.";
    } else if(x==2){
        p.innerHTML="<span>Estado bueno</span></br> El bien presenta algunos síntomas de deterioro, pero la profundidad, extensión e intensidad de su manifestación es de carácter leve y afectan a menos del 50% de su superfcie total. No registra deterioros a nivel de su estructura y/o en sus materiales constitutivos.";
    }else if(x==3){
        p.innerHTML="<span>Estado regular</span></br>El bien presenta varios síntomas de deterioro, y la profundidad, extensión e intensidad de su manifestación afectan entre el 50% y menos del 75% de su superfcie total, generando problemas de magnitud intermedia en su estructura y morfología.";
    }else if(x==4){
        p.innerHTML="<span>Estado malo</span></br>El bien presenta numerosos síntomas de deterioro cuya profundidad, extensión, intensidad y dinámica afectan al 75% de su superfcie total, difcultando su manipulación debido a la inestabilidad de sus materiales constitutivos, su debilidad estructural y morfológica. Registra fenómenos activos de deterioro y desaparición parcial de su iconografía y/o morfología.";
    }else if(x==5){
        p.innerHTML="<span>Estado muy malo</span></br>El bien presenta graves síntomas de deterioro cuya profundidad, extensión, intensidad y dinámica afectan el 100% de su superfcie total, poniendo en riesgo su estabilidad material y estructural e impidiendo seriamente su manipulación. O bien: el daño sufrido impide reconocer a través de un examen macroscópico su morfología o iconografía. Registra fenómenos activos de daño y requiere trabajos de conservación de carácter urgente.";
    }
}


/*Estado de conservación gráfico estratos*/

function cambiarEstrato(e){
    switch (e) {
        case 1:
            estratosP.setAttribute("src","images/estratos/Estrato A.svg");
            break;
        case 2:
            estratosP.setAttribute("src","images/estratos/Estrato B.svg");
            break;
        case 3:
        estratosP.setAttribute("src","images/estratos/Estrato C.svg");
            break;
        case 4:
            estratosP.setAttribute("src","images/estratos/Estrato D.svg");
            break;
        case 5:
            estratosP.setAttribute("src","images/estratos/Estrato E.svg");
            break;
        default:
            break;
    }
     
    
    
    
}





/*----Select OTRO -->Desplegar textarea (Solo se esta aplicando a ficha/tecnicas)---*/

$(document).ready(function(){ 
    $('.otro').css("display", "none");
    $('.oS').on('change',function(){
        var selectedValue = $(this).val(); 
        if(selectedValue == "otro"){
          $(this).next().toggle('slow');
        }
        e.preventDefault();
    },
    function(e){
        $('.otro').css("display", "none");
        var selectedValue = $(this).val(); 
        if(selectedValue == "otro"){
          $(this).next().toggle('slow');
        }
    });
});


/*Textarea checkbox */
function crearTxt(){
    var boxT=document.getElementById('boxTxt');
    var txtC= document.createElement("textarea");
    boxT.appendChild(txtC);
}
/*Problema con .next() porque el input se encuentra anidado en el label y luego hay salto de línea*/
/*Opción 2 --> crear el elemento textarea al clickear pero se debe revisar como destruirlo al destildarse*/
$(document).ready(function(){ 
    $('.contenido').css("display", "none");
    $('.describir').on('click',function(){
        
        $(this).next().toggle('slow');
    
        e.preventDefault();
    },
    function(e){
        $('.contenido').css("display", "none");
       
        $(this).next().toggle('slow');
        
    });
});




/*Estado de conservación --> desplegar estrato*/

function mostrarEstrato(valor){
    if(valor==1){
        
        var x = document.querySelector('#ocultarEstrato1');
    }else if(valor==2){
        var x = document.querySelector('#ocultarEstrato2');
    }else if(valor==3){
        
        var x = document.querySelector('#ocultarEstrato3');
    }else if(valor==4){
        
        var x = document.querySelector('#ocultarEstrato4');
    }else if(valor==5){
        
        var x = document.querySelector('#ocultarEstrato5');
    }else if(valor==6){
        
        var x = document.querySelector('#ocultarEstrato6');
    }else if(valor==7){
        
        var x = document.querySelector('#ocultarEstrato7');
    } else if(valor==8){
        
        var x = document.querySelector('#ocultarEstrato8');
    }else if(valor==9){
        
        var x = document.querySelector('#ocultarEstrato9');
    }else if(valor==10){
        
        var x = document.querySelector('#ocultarEstrato10');
    }
    
    
    if (x.style.display === "block") {
        x.style.display = "none";
    } else {
        x.style.display = "block";
    }
    
}



/*Cambiar grafico de uniones*/
uniones.addEventListener("change",()=>{
    unionImg.setAttribute("src","images/uniones/"+uniones.selectedOptions[0].value+".svg")
});

/*Cambiar grafico de cortes*/
corteM.addEventListener("change",()=>{
    corteImg.setAttribute("src","images/cortes/"+corteM.selectedOptions[0].value+".svg")
});

/*Cambiar grafico de tramas*/
trama.addEventListener("change",()=>{
    tejidoImg.setAttribute("src","images/tejidos/"+trama.selectedOptions[0].value+".svg")
});
/*Cambiar grafico de torsión*/
torsionT.addEventListener("change",()=>{
    torsionImg.setAttribute("src","images/tejidos/"+torsionT.selectedOptions[0].value+".svg")
});

torsionU.addEventListener("change",()=>{
    torsionImg.setAttribute("src","images/tejidos/"+torsionU.selectedOptions[0].value+".svg")
});

/*soporte principal --> desplegar formulario seún material elegido */
$(document).ready(function(){ 
    $('#estadoMaterialM').css("display", "block");
    $('#estadoMaterialT').css("display", "none");
    $('#materialSP').on('change',function(){
        var selectedValue = $(this).val(); 
        if(selectedValue == "Madera"){
            $('#estadoMaterialM').css("display", "block");
        }else if (selectedValue == "Textil"){
            $('#estadoMaterialT').css("display", "block");
        }
        e.preventDefault();
    },
    function(e){
        $('#estadoMaterialM').css("display", "none");
        $('#estadoMaterialT').css("display", "none");
        var selectedValue = $(this).val(); 
        if(selectedValue == "Madera"){
            $('#estadoMaterialM').css("display", "block");
        }else if (selectedValue == "Textil"){
            $('#estadoMaterialT').css("display", "block");
        }
    });
});

/*Estudios relizados --> desplegar observaciones*/

function mostrarEstudio(valor){
    if(valor==1){
        
        var x = document.querySelector('#ocultarEstudio1');
    }else if(valor==2){
        var x = document.querySelector('#ocultarEstudio2');
    }else if(valor==3){
        
        var x = document.querySelector('#ocultarEstudio3');
    }else if(valor==4){
        
        var x = document.querySelector('#ocultarEstudio4');
    }else if(valor==5){
        
        var x = document.querySelector('#ocultarEstudio5');
    }else if(valor==6){
        
        var x = document.querySelector('#ocultarEstudio6');
    }else if(valor==7){
        
        var x = document.querySelector('#ocultarEstudio7');
    } else if(valor==8){
        
        var x = document.querySelector('#ocultarEstudio8');
    }else if(valor==9){
        
        var x = document.querySelector('#ocultarEstudio9');
    }else if(valor==10){
        
        var x = document.querySelector('#ocultarEstudio10');
    }
    
    
    if (x.style.display === "block") {
        x.style.display = "none";
    } else {
        x.style.display = "block";
    }
    
}









/*
$(document).ready(function(){ 
    $('.describir').on('click',function(){
        
        $('.contenido').toggle('slow');
       
    });
});

$(document).ready(function(){ 
    $('.describir').next().css("display", "none");
    $('.describir').on('click',function(){
         $(this).next().toggle('slow');
    });
});*/

/*Retauracion --> agregar pasos */

function agregarPaso (){
    var icono=document.querySelector('#i');
    var paso=document.querySelector('#paso');
    var tratamiento=document.querySelector('#tratamiento');
    var producto=document.querySelector('#producto');
    
    
    var i=document.createElement("i");
    i.className='fas fa-minus-circle agregaPaso rm';
    i.id="rm";
    icono.appendChild(i);
    var br=document.createElement("br");
    icono.appendChild(br);
    
    var pasoL=document.createElement("label");
    pasoL.textContent="Paso n°";
    pasoL.id="rmPaso";
    paso.appendChild(pasoL);
    var pasoS=document.createElement("br")
    paso.appendChild(pasoS);
    var pasoI=document.createElement("input");
    pasoI.type="number";
    pasoI.id="rmPasoI"
    paso.appendChild(pasoI);
    var pasoSS=document.createElement("br")
    paso.appendChild(pasoSS);
    
    
    var tratamientoL=document.createElement("label");
    tratamientoL.textContent="Tratamiento";
    tratamiento.appendChild(tratamientoL);
    var tratamientoS=document.createElement("br");
    tratamiento.appendChild(tratamientoS);
    var tratamientoI=document.createElement("input");
    tratamientoI.type="text";
    tratamiento.appendChild(tratamientoI);
    var tratamientoSS=document.createElement("br");
    tratamiento.appendChild(tratamientoSS);
    

    var productoL=document.createElement("label");
    productoL.textContent="Producto";
    producto.appendChild(productoL);
    var productoS=document.createElement("br");
    producto.appendChild(productoS);
    var productoI=document.createElement("input");
    productoI.type="text";
    producto.appendChild(productoI);
    var productoSS=document.createElement("br");
    producto.appendChild(productoSS);
}

/*Remover pasos agregados */

    /*
    $("#rm").click(function(){
       /* 
        $('#rmPaso').empty();
        $('#rmPaso').remove();
        $('#rmPasoI').empty();
        $('#rmPasoI').remove(); 
        
        
        var pasoL=document.getElementById("rmPaso");
        p= pasoL.parentNode();
        p.removeChild(pasoL);
        var pasoI=document.getElementById("rmPasoI");
        q= pasoI.parentNode();
        q.removeChild(pasoI);
        var i=document.getElementById("rm");
        i.parentNode().removeChild(i.firstChild);

    });*/

/*
function remove(item) {
    var elem = document.querySelectorAll(item);
    for(var i=0; i<elem.length; i++) {
        var del = elem[i];
        del.parentNode.removeChild(del); 
    }
}

$('#rm').click(remove('#rm'));*/

$(document).ready(function(){ 
    $('#rm').on('click',function(){
        
        
        
        var pasoLL=document.querySelector("#rmPaso");
        var p=pasoLL.parentNode();
        p.removeChild(p);

        var pasoII=document.querySelector("#rmPasoI");
        var q= pasoII.parentNode();
        q.removeChild(q);
        
        



    });
});

/*
var rm=document.getElementById('rm');
$('#rm').click(function() {
    var myNode = document.getElementById("rm"); 
    while(myNode.hasChildNodes()) 
    { 
        myNode.removeChild(myNode.lastChild); 
    }
})
*/

/*
document.getElementById("rm").addEventListener("click",function(){ 

    let parent_node =document.getElemetById("rm"); 
    let last_child =parent_node.lastChild; 
    while(last_child){ 
     parent_node.removeChild(last_child); 
    } 
}) */

/*
document.querySelector("#rm").addEventListener("click",function(){
    var paso=document.querySelector('#paso');
    var pasoI=document.querySelector("#rmPasoI");
    paso.removeChild(pasoI);
});*/




/*CREAR COLECCIÓN --> agregar objeto */

function agregarObjeto (){
    var icono=document.querySelector('#iC');
    var inventario=document.querySelector('#inventarioC');
    var titulo=document.querySelector('#tituloC');
    var objeto=document.querySelector('#objetoC');
    var autor=document.querySelector('#autorC');
    
    
    
    var i=document.createElement("i");
    i.className='fas fa-minus-circle agregaPaso rm';
    i.id="rm";
    icono.appendChild(i);
    var br=document.createElement("br");
    icono.appendChild(br);
    
    var inventarioL=document.createElement("label");
    inventarioL.textContent="N° inventario";
    inventarioL.id="rmInventario";
    inventario.appendChild(inventarioL);
    var inventarioS=document.createElement("br")
    inventario.appendChild(inventarioS);
    var inventarioI=document.createElement("input");
    inventarioI.type="number";
    inventarioI.id="rmPasoI"
    inventario.appendChild(inventarioI);
    var inventarioSS=document.createElement("br")
    inventario.appendChild(inventarioSS);
    
    
    var tituloL=document.createElement("label");
    tituloL.textContent="Título";
    titulo.appendChild(tituloL);
    var tituloS=document.createElement("br");
    titulo.appendChild(tituloS);
    var tituloI=document.createElement("input");
    tituloI.type="text";
    titulo.appendChild(tituloI);
    var tituloSS=document.createElement("br");
    titulo.appendChild(tituloSS);
    
    /*
    var autorL=document.createElement("label");
    autorL.textContent="Autor";
    autor.appendChild(autorL);
    var autorS=document.createElement("br");
    autor.appendChild(autorS);
    var autorI=document.createElement("input");
    autorI.type="text";
    autor.appendChild(autorI);
    var autorSS=document.createElement("br");
    autor.appendChild(autorSS);*/

    var objetoL=document.createElement("label");
    objetoL.textContent="Objeto";
    objeto.appendChild(objetoL);
    var objetoS=document.createElement("br");
    objeto.appendChild(objetoS);
    var objetoI=document.createElement("input");
    objetoI.type="text";
    objeto.appendChild(objetoI);
    var objetoSS=document.createElement("br");
    objeto.appendChild(objetoSS);
}
