/**
 * Created by Daniel jose on 20/03/2017.
 */
angular.module('webAppVtrackApp.services')
    .service('ServicioDetalladoPedido',['$q','$rootScope','$http','BASE_URL',ServicioDetalladoPedido]);

function ServicioDetalladoPedido($q,$rootScope,$http,BASE_URL,$scope) {

    var pedidoSeleccionado;
    this.getPedidoSeleccionado = getPedidoSeleccionado;
    this.setPedidoSeleccionado = setPedidoSeleccionado;
    this.consultarPedido = consultarPedido;
    function setPedidoSeleccionado(valor) {
        pedidoSeleccionado = valor;
    }

    function getPedidoSeleccionado() {
        return pedidoSeleccionado;
    }

    function consultarPedido(idPedido) {
        console.log('entrando a la funcion consultarPedido');
        var defered = $q.defer();
        var promise = defered.promise;
        $http
        ({
            method: 'GET',
            url: BASE_URL + '/pedido/'+idPedido,
            headers: {
                'Authorization': $rootScope.tokenAuth,
                'Content-Type': 'application/json'
            }/*,
             data: JSON.stringify($rootScope.correouser)*/
        }).then(function success(response)
        {
            console.log(response);
            defered.resolve(response.data);
        },function error(response)
        {
            console.log('error: '+response);
            var error = response.data;
            defered.reject(error.mensaje);
        });
        return promise;
        console.log('saliendo de la funcion consultarPedido');
    }
}
