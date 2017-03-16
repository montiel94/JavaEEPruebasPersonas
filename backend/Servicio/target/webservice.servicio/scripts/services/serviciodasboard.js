/**
 * Created by Daniel jose on 10/03/2017.
 */
angular.module('webAppVtrackApp.services')
    .service('ServicioDashboard',['$q','$rootScope','$http','BASE_URL',ServicioDashboard]);

function ServicioDashboard($q,$rootScope,$http,BASE_URL,$scope) {

    this.logout = logout;

    function logout(auth) {
        console.log('entrando al metodo logut');
        var defered = $q.defer();
        var promise = defered.promise;
        $http
        ({
            method: 'delete',
            url: BASE_URL + '/auth/token',
            headers: {
                'Content-Type': 'application/json'
            },
            data: JSON.stringify($rootScope.tokenAuth)
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
        console.log('saliendo del metodo logut');
    }

}
