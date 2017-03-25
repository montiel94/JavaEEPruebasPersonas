/**
 * Created by Daniel jose on 22/03/2017.
 */
angular.module('webAppVtrackApp.services')
    .service('ServicioPerfil',['$q','$rootScope','$http','BASE_URL',ServicioPerfil]);

function ServicioPerfil($q,$rootScope,$http,BASE_URL,$scope) {

    var pedidoSeleccionado;
    this.getUsuario = getUsuario;

    function getUsuario(correoEmpresa) {
        console.log('entrando a la funcion getUsuario');
        var defered = $q.defer();
        var promise = defered.promise;
        $http
        ({
            method: 'GET',
            url: BASE_URL + '/usuario/'+correoEmpresa,
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
        console.log('saliendo de la funcion getUsuario');
    }
}

