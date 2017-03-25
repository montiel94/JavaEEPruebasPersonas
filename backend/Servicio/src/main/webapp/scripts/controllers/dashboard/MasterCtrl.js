/**
 * Created by Daniel jose on 07/03/2017.
 */
angular.module('webAppVtrackApp')
    .controller('MasterCtrl', ['$scope', '$cookieStore', '$log','$rootScope','$state','ServicioDashboard',MasterCtrl]);

function MasterCtrl($scope, $cookieStore,$log,$rootScope,$state,ServicioDashboard) {
    /**
     * Sidebar Toggle & Cookie Control
     */
    var mobileView = 992;

    $scope.init = function()
    {
        console.log('entrando al metodo onloadpage');
        if (angular.isUndefined($rootScope.tokenAuth)) {
            $state.go('login');
        }
        else
        {
            $rootScope.page = 'dashboard';
        }
        console.log('saliendo del mtodo onloadpage');
    };

    $scope.getWidth = function() {
        return window.innerWidth;
    };

    $scope.$watch($scope.getWidth, function(newValue, oldValue) {
        if (newValue >= mobileView) {
            if (angular.isDefined($cookieStore.get('toggle'))) {
                $scope.toggle = ! $cookieStore.get('toggle') ? false : true;
            } else {
                $scope.toggle = true;
            }
        } else {
            $scope.toggle = false;
        }

    });

    $scope.toggleSidebar = function() {
        $scope.toggle = !$scope.toggle;
        $cookieStore.put('toggle', $scope.toggle);
    };

    window.onresize = function() {
        $scope.$apply();
    };
    //////////////////////////////////////////
    $scope.items = [
        'The first choice!',
        'And another choice for you.',
        'but wait! A third!'
    ];

    $scope.status = {
        isopen: false
    };

    $scope.toggled = function(open) {
        $log.log('Dropdown is now: ', open);
    };

    $scope.toggleDropdown = function($event) {
        $event.preventDefault();
        $event.stopPropagation();
        $scope.status.isopen = !$scope.status.isopen;
    };

    $scope.appendToEl = angular.element(document.querySelector('#dropdown-long-content'));

    $scope.onloadPage = function () {
        console.log('entrando al metodo onloadpage');
        if (angular.isUndefined($rootScope.tokenAuth)) {
            $state.go('login');
        }
        console.log('saliendo del mtodo onloadpage');
    }

    $scope.logoutVtrack = function () {
        console.log('entrando al metodo logout logoutVtrack');

        ServicioDashboard.logout()
            .then(function(data){
                console.log('se realizo logout exitosamente');
                var error = data;
                $rootScope.tokenAuth = undefined;
                $rootScope.correouser = undefined;
                $state.go( 'login' );
            })
            .catch(function (error) {
                console.log('se produjo un error en el login');
                mostrarError(error);
            });
        console.log('saliendo del metodo logout logoutVtrack');
    }

    $scope.menuDashboard = function () {
        console.log('entrando al metodo menuDashboard');
        $state.go( 'dashboardpedidos' );
        console.log('entrando al metodo menuDashboard');
    }

    $scope.cambiarTemplate = function () {
        console.log('entrando al metodo menuDashboard');
        $state.go( 'dashboardgenerarpedido' );
        console.log('entrando al metodo menuDashboard');
    }

    $scope.goToPerfil = function () {
        console.log('entrando al metodo goToPerfil');
        $state.go( 'perfil' );
        console.log('entrando al metodo goToPerfil');
    }

}
