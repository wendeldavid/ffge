'use strict';

// FIXME alterar para produção

var app = angular.module('ffge', [ 'ui.bootstrap', 'ui.bootstrap.tpls', 'angularModalService' ]);

app.controller('FFCtrl', [ '$scope', '$http', 'ModalService', function($scope, $http, ModalService) {

    $scope.currentPage = 1;
    $scope.offset = 0;
    $scope.limit = 9;
    $scope.ff = {};
    $scope.ff.grosserias = [];

    $scope.paginate = function() {
        $scope.offset = parseInt($scope.currentPage + '0') - 10, parseInt($scope.currentPage + '0');
        $scope.limit = $scope.currentPage + 10;
    }

    $scope.load = function() {
        $http.get(window.location.href + 'Servlet').then(function(success) {
            $scope.ff = success.data.ff;
            $scope.ff.grosserias = success.data.ff.grosserias.reverse();
        }, function(error) {
            console.log(error);
        });
    }

    $scope.like = function(grosseriaId) {
        $http.post(window.location.href + 'Like', grosseriaId).then(function(success) {
            $scope.load();
        }, function(error) {
            console.log(error);
        });
    }

    $scope.openModal = function() {
        ModalService.showModal({
            templateUrl : 'modal.html',
            controller : "ModalController"
        }).then(function(modal) {
            modal.element.modal();

            modal.close.then(function(params) {
                console.log(params);
                if (!!params) {
                    $http.put(window.location.href + 'Servlet', params).then(function(sucess) {
                        $scope.load();
                    }, function(error) {
                        console.log(error);

                        if (error.status == 403) {
                            ModalService.showModal({
                                templateUrl : 'ffdenied.html',
                                controller : 'ModalController'
                            }).then(function(modal) {
                                modal.element.modal();
                            });
                        }
                    });

                }
            });
        });
    }

    $scope.openSubscribe = function() {
        ModalService.showModal({
            templateUrl : 'email.html',
            controller : "EmailController"
        }).then(function(modal) {
            modal.element.modal();

            modal.close.then(function(params) {
                console.log(params);
                if (!!params) {
                    $http.post(window.location.href + 'Subscribe', params).then(function(sucess) {
                        if (params.acao == 'subscribe') {
                            console.log('email cadastrado com sucesso!');
                        } else if (params.acao == 'unsubscribe') {
                            console.log('email descadastrado com sucesso!');
                        }
                    }, function(error) {
                        console.log(error);

                        if (error.status == 403) {
                            ModalService.showModal({
                                templateUrl : 'ffdenied.html',
                                controller : 'ModalController'
                            }).then(function(modal) {
                                modal.element.modal();
                            });
                        }
                    });

                }
            });
        });
    }

    $scope.getPage = function(currentPage) {
        return $scope.ff.grosserias.slice(parseInt(currentPage + '0') - 10, parseInt(currentPage + '0'));
    }

} ]);

app.controller('ModalController', function($scope, close) {

    $scope.modal = {};
    $scope.modal.acao = 'Grosseiro';

    $scope.sendOffense = function() {
        close($scope.modal, 500);
    }

    $scope.close = function(result) {
        close(undefined, 500); // close, but give 500ms for bootstrap to animate
    }

});

app.controller('EmailController', function($scope, close) {

    $scope.subscribeEmail = function() {
        $scope.modal.acao = 'subscribe';
        close($scope.modal, 500);
    }

    $scope.unsubscribeEmail = function() {
        $scope.modal.acao = 'unsubscribe';
        close($scope.modal, 500);
    }

    $scope.close = function(result) {
        close(undefined, 500); // close, but give 500ms for bootstrap to animate
    }

});
