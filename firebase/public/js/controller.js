'use strict';

var app = angular.module('ffge', [ 'ui.bootstrap', 'ui.bootstrap.tpls', 'ngRoute' ]);

app.controller('FFCtrl', [
		'$rootScope',
		'$scope',
		function($rootScope, $scope) {

			$scope.currentPage = 1;
			$scope.offset = 0;
			$scope.limit = 9;
			$scope.ff = {};
			$scope.ff.grosserias = [];

			$scope.paginate = function() {
				$scope.offset = parseInt($scope.currentPage + '0') - 10,
						parseInt($scope.currentPage + '0');
				$scope.limit = $scope.currentPage + 10;
			}

			$scope.load = function() {

				var config = {
					apiKey : "AIzaSyAXS9kKJzKYmmbapS3Z7BKHjwri1_lInhA",
					authDomain : "ffge-9a4e7.firebaseapp.com",
					databaseURL : "https://ffge-9a4e7.firebaseio.com",
					storageBucket : "ffge-9a4e7.appspot.com",
					messagingSenderId : "106420336131"
				};
				firebase.initializeApp(config);

				var database = firebase.database();

				var grosserias = firebase.database().ref('grosserias');
				grosserias.on('value', function(snapshot) {
					$scope.$apply(function() {
						$scope.ff.grosserias = snapshot.val().reverse();
						
						$scope.calcCurrentStatus();
						$scope.calcRecord();
					});
				});
			}
			
			$scope.calcCurrentStatus = function(){
				var lastDate = $scope.ff.grosserias[0].data;
				var end = new Date(lastDate.date.year, lastDate.date.month, lastDate.date.day, lastDate.time.hour, lastDate.time.minute, lastDate.time.second, lastDate.time.nano);
				var now = new Date();

				$scope.ff.dias = Math.round(end.getDay() - now.getDay());
			}

			$scope.calcRecord = function(){
				var begin = $scope.ff.grosserias[0]; 
				var end = $scope.ff.grosserias[1];
				var record = $scope.diffDays(begin.data, end.data);
				for (var i = 1; i < $scope.ff.grosserias.length; i++){
					begin = $scope.ff.grosserias[i];
					end = $scope.ff.grosserias[i + 1];

					if(!!end){
						var diff = $scope.diffDays(begin.data, end.data);
						if(diff > record){
							record = diff;
						}
					}
				}
				
				$scope.ff.recorde = record;
			}
			
			$scope.diffDays = function(begin, end){
				var oneDay = 24*60*60*1000; // hours*minutes*seconds*milliseconds
				
				var beginDate = new Date(begin.date.year, begin.date.month, begin.date.day, begin.time.hour, begin.time.minute, begin.time.second);
				var endDate = new Date(end.date.year, end.date.month, end.date.day, end.time.hour, end.time.minute, end.time.second);
				
				return Math.round(Math.abs((beginDate.getTime() - endDate.getTime())/(oneDay)));
			}
			
			$scope.getPage = function(currentPage) {
				return $scope.ff.grosserias.slice(
						parseInt(currentPage + '0') - 10,
						parseInt(currentPage + '0')).reverse();
			}

		} ]);
