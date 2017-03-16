/**
 * Created by Daniel jose on 13/03/2017.
 */
angular.module('webAppVtrackApp.services')
    .service('ServicioPedidos',['$q','$rootScope','$http','BASE_URL',ServicioPedidos]);

function ServicioPedidos($q,$rootScope,$http,BASE_URL,$scope) {

    this.getAllPedidos = getAllPedidos;

    function getAllPedidos() {
        console.log('entrando al metodo getAllPedidos');
        var defered = $q.defer();
        var promise = defered.promise;
        $http
        ({
            method: 'GET',
            url: BASE_URL + '/pedidos/all/'+$rootScope.correouser,
            headers: {
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
        console.log('saliendo del metodo getAllPedidos');
    }

}
