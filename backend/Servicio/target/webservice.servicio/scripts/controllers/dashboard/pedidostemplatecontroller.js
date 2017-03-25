/**
 * Created by Daniel jose on 12/03/2017.
 */
/**
 * @ngdoc function
 * @name webAppVtrackApp.controller:LoginctrlCtrl
 * @description
 * # LoginctrlCtrl
 * Controller of the webAppVtrackApp
 */
angular.module('webAppVtrackApp')
    .controller('PedidosCtrl', ['$scope', '$location', '$rootScope','ServicioPedidos','$state','ServicioDetalladoPedido','ServicioPerfil',PedidosCtrl]);

function PedidosCtrl($scope, $location, $rootScope,ServicioPedidos,$state,ServicioDetalladoPedido,ServicioPerfil)
{
    var view = $scope;
    this.inputBuscador = inputBuscador;
    var modoDebug = false;


    /*
        Descripcion : agrega pedidos consultados del ws a la tabla del template
     */
    function agregarFilasTablaPedidos() {
        var tbodyTablaPedidos =
            angular.element(document.querySelector('#tbodyTablaPedidos'));
            var pedidos = $scope.pedidos;
            var estado = "";
            for(pedido in pedidos) {
                if (pedidos[pedido].estado == 0)
                    estado = "En espera";
                if (pedidos[pedido].estado == 1)
                    estado = "En Turno para Llenado";
                if (pedidos[pedido].estado == 2)
                    estado = "Autorizado y Llamado a Llenado";
                if (pedidos[pedido].estado == 3)
                    estado = "Pesado Inicial";
                if (pedidos[pedido].estado == 4)
                    estado = "Llenando";
                if (pedidos[pedido].estado == 5)
                    estado = "Llenado";
                if (pedidos[pedido].estado == 6)
                    estado = "Pesado Final";
                if (pedidos[pedido].estado == 7)
                    estado = "Cargado";
                tbodyTablaPedidos.append('<tr class="filaTablaPedidos"><td>'+pedidos[pedido].codigoPedido+'</td><td>'+estado+'</td><td>'+pedidos[pedido].fechaCreacion+'</td></tr>');
            }
    }

    $scope.seleccionPedidoTable = function () {
        console.log('entrando al metodo seleccionPedidocontroller');

        console.log('saliendo del metodo seleccionPedidocontroller');
    }
    /*
           Descripcion : totaliza el numero de pedidos segun estados y los caraga en el template
     */
    function agregarNumeroDeTotalizacion() {

        var contadorEnEspera = 0;
        var contadorAutorizado = 0;
        var contadorLlenando = 0;
        var contadorCargado = 0;
        var pedidos = $scope.pedidos;
        for (i in pedidos)
        {
            if (pedidos[i].estado == 0)
                contadorEnEspera = contadorEnEspera + 1;
            if(pedidos[i].estado == 2)
                contadorAutorizado = contadorAutorizado + 1;
            if(pedidos[i].estado == 4)
                contadorLlenando = contadorLlenando + 1;
            if(pedidos[i].estado == 7)
                contadorCargado = contadorCargado + 1;
        }

        var rdwidgetbodyencola =
            angular.element(document.querySelector('#rd-widget-body-en-cola'));
        rdwidgetbodyencola.append('<div class="title">'+contadorEnEspera+'</div>');

        var rdwidgetbodyenchuto =
            angular.element(document.querySelector('#rd-widget-body-en-chuto'));
        rdwidgetbodyenchuto.append('<div class="title">'+contadorAutorizado+'</div>');

        var rdwidgetbodyterminando =
            angular.element(document.querySelector('#rd-widget-body-terminando'));
        rdwidgetbodyterminando.append('<div class="title">'+contadorLlenando+'</div>');

        var rdwidgetbodysaliendo =
            angular.element(document.querySelector('#rd-widget-body-saliendo'));
        rdwidgetbodysaliendo.append('<div class="title">'+contadorCargado+'</div>');

    }
    /*
        agrega funcion onClick en las filas de las tablas
     */
    function agregarHandlersFilas() {

        var table = document.getElementById("myTable");
        var rows = table.getElementsByTagName("tr");
        for (i = 0; i < rows.length; i++) {
            var currentRow = table.rows[i];
            var createClickHandler =
                function(row)
                {
                    return function() {
                        var cell = row.getElementsByTagName("td")[0];
                        var id = cell.innerHTML;
                        ServicioDetalladoPedido.setPedidoSeleccionado(id);
                        $state.go( 'dashboarddetalladopedido' );
                    };
                };

            currentRow.onclick = createClickHandler(currentRow);
        }

    }
    /*
        consulta al ws todos los pedidos de la empresa y los carga en el template
     */
    function getAllPedidos() {
        console.log('entrando al metodo getAllPedidos');
        ServicioPedidos.getAllPedidos()
            .then(function(data){
                console.log('se hizo correctamente llamada al servicio rest');
                $scope.pedidos = data;
                agregarFilasTablaPedidos();
                agregarNumeroDeTotalizacion();
                agregarHandlersFilas();
            })
            .catch(function (error) {
                console.log('se produjo un error llamando al servicio rest');
                $state.go( 'login' );
            });
        console.log('saliendo de el metodo getAllPedidos');
    }

    $scope.init =  function()
    {
        console.log('entrando al metodo onloadpage');
        if (angular.isUndefined($rootScope.tokenAuth)) {
            $state.go('login');
        }
        else {
            if (modoDebug == true) {
                console.log('modoDebug activado');

            }
            else {
                getAllPedidos();
                consultarEmpresa();
                console.log('modoDebug Desactivado');
            }
        }
        console.log('saliendo del mtodo onloadpage');
    };
    
    function  consultarEmpresa() {
        console.log('entrando a la funcion consultarEmpresa');
        ServicioPerfil.getUsuario($rootScope.correouser)
            .then(function(data){
                console.log('se hizo correctamente llamada al servicio rest');
                var pNombreEmpresa =
                    angular.element(document.querySelector('#nombreEmpresa'));
                pNombreEmpresa.append(data.nombreempresa);
            })
            .catch(function (error) {
                console.log('se produjo un error llamando al servicio rest');
                $state.go( 'login' );
            });
        console.log('saliendo de la funcion consultarEmpresa');
    }
}