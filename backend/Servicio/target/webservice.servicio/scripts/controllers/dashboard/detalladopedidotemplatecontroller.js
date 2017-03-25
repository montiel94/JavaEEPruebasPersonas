/**
 * Created by Daniel jose on 20/03/2017.
 */
angular.module('webAppVtrackApp')
    .controller('DetalladoPedidoCtrl', ['$scope', '$location', '$rootScope','$state','ServicioDetalladoPedido',DetalladoPedidoCtrl]);

function DetalladoPedidoCtrl($scope, $location, $rootScope,$state,ServicioDetalladoPedido)
{
    var view = $scope;
    var modoDebug = true;

    $scope.init =  function()
    {
        console.log('entrando al metodo onloadpage');
        if (angular.isUndefined($rootScope.tokenAuth)) {
            $state.go('login');
        }
        else {
            if (modoDebug == true) {
                console.log('modoDebug activado');
                pintarInformacionPedido();
            }
            else {

                console.log('modoDebug Desactivado');
            }
        }
        console.log('saliendo del mtodo onloadpage');
    };

    function pintarInformacion(data) {
        console.log('entrando a la funcion pintarInformacion');
        var divInformacion =
            angular.element(document.querySelector('#filasInformacion'));
            divInformacion.append('<tr style="text-align:center;"><td>Codigo del pedido</td><td>'+data.codigoPedido+'</td></tr>');
            divInformacion.append('<tr style="text-align:center;"><td>Conductor</td><td >'+data.chofer+'</td></tr>');
            divInformacion.append('<tr style="text-align:center;"><td>Estado</td><td >'+transformarEstadoPedido(data.estado)+'</td></tr>');
            divInformacion.append('<tr style="text-align:center;"><td>Fecha de creacion</td><td>'+data.fechaCreacion+'</td></tr>');
        console.log('saliendo de la funcionpintarInformacion');
    }

    function transformarEstadoPedido(estadoPedido) {
        console.log('entrando a la funcion transformarEstadoPedido');
        var estado = '';
        if (estadoPedido == 0)
            estado = "En espera";
        if (estadoPedido == 1)
            estado = "En Turno para Llenado";
        if (estadoPedido == 2)
            estado = "Autorizado y Llamado a Llenado";
        if (estadoPedido == 3)
            estado = "Pesado Inicial";
        if (estadoPedido == 4)
            estado = "Llenando";
        if (estadoPedido == 5)
            estado = "Llenado";
        if (estadoPedido == 6)
            estado = "Pesado Final";
        if (estadoPedido == 7)
            estado = "Cargado";
        return estado;
        console.log('saliendo de la funcion transformarEstadoPedido');
    }

    function pintarInformacionVehiculo(data) {
        console.log('entrando a la funcion pintarInfromacionVehiculo');
        var tbodyInformacionVehiculo =
            angular.element(document.querySelector('#tbodyInformacionVehiculo'));
        tbodyInformacionVehiculo.append('<tr style="text-align:center;"><td>Placa de la sisterna</td><td >'+data.cola+'</td></tr>');
        tbodyInformacionVehiculo.append('<tr style="text-align:center;"><td>Placa del chuto</td><td >'+data.cabezote+'</td></tr>');
        console.log('saliendo de la funcioin pintarInformacionVehiculo');
    }

    function pintarEventos(data) {
        console.log('entrando a la funcion pintarEventos');
        var eventos = data.eventos;
        eventos = eventos.sort (function(a, b) {
            return parseFloat(a.id) - parseFloat(b.id);
        });
        var tbodyInformacionEventos =
            angular.element(document.querySelector('#tbodyInformacionEventos'));
        for (evento in eventos)
        {
            tbodyInformacionEventos.append('<tr style="text-align:center;"><td>'+eventos[evento].mensaje+'</td><td >'+eventos[evento].tiempo+'</td></tr>');
        }
        console.log('saliendo de la funcion pintarEventos');
    }

    function pintarInformacionPedido() {

        var idPedido = ServicioDetalladoPedido.getPedidoSeleccionado()
        ServicioDetalladoPedido.consultarPedido(idPedido)
            .then(function(data){
                console.log('se hizo correctamente llamada al servicio rest');
                pintarInformacion(data);
                pintarInformacionVehiculo(data);
                pintarEventos(data);

            })
            .catch(function (error) {
                console.log('se produjo un error llamando al servicio rest');
                $state.go( 'login' );
            });


    }

}