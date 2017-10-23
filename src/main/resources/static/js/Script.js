///<reference path="angular.js"/>
var myApp = angular.module("myModule",['$modal']);
myApp.controller("myController",function($scope,$http,$log,$window,$modal){
	$scope.message = "Hello Angular!!";
	$scope.takeinput = "login.html";
	
	 $scope.data = [];
	 $scope.employees=undefined;

	    $scope.loadData=function() {
	    	$http.get("http://localhost:8081/employee/").then(function(response){
	    		$scope.employees = response.data;
	            })
	            .catch(function(error) {
	                $scope.error = error;
	            });
	    }

	    $scope.loadData();
	
	$scope.openPopUp = function () {
	console.log('opening pop up');
	var modalInstance = $modal.openPopUp({
	templateUrl: 'popup.html',
	controller: 'PopupCont',
	});

	var fetchData = function(){
	$http.get("http://localhost:8081/employee/").then(function(response){
	$scope.employees = response.data;
			});
	};
	$scope.AngularAlert = function (message) {
		if(message === 'Hello'){
			console.log("Please type Hello");
			$scope.checkUBRRPL = true;
		}
		else{
			$window.alert(message);
			$scope.checkUBRRPL = false;
		}
      };
    
	$scope.fetchData = fetchData;
	
	
	var successCallBack = function(response){
		$scope.StatusOfEnv = response.data;
		$log.info(response);
	};
	var errorCallBack = function(response){
		$scope.error = response.data;
		$log.info(response);
	};
	$scope.onclickPopUp = fucntion(){
		$rootScope.$broadcast('app:error',{msg:'No Files found'});
	};
	$scope.submitData = function(one,two,three){
		var dataObjo={};
		dataObjo.name=one;
		dataObjo.designation=two;
		dataObjo.sapid=+three;
		$http.post('http://localhost:8081/employee/Insert',dataObjo).then(successCallBack,errorCallBack);		
	};
		$scope.toconsole = function(one,two,three){
		console.log("To Print"+ one);
		var dataObj={};
		dataObj.name=one;
		var toPostCall = 'kasdkfj';
		dataObj.designation=two;
		dataObj.sapid=+three;
		$http.post('http://localhost:8081/studentPostTest',toPostCall).then(successCallBack,errorCallBack);
		console.log(dataObj.designation);
	};
		$scope.toneelam = function(one,two,three){
		console.log("To Print"+ one);
		var dataObj={};
		for(var i in dataObj){
		dataObj[i]=one;
		dataObj[i]=two;
		dataObj[i]=+three;
		console.log(dataObj);
		}
	};
       var close = function(){
//    	   console.log("Called Close function")
//       localStorage.clear();
//       sessionStorage.clear();
//       console.log("First Test");
//       open('http://localhost:8081/','_self').close();
//      // pen(location, '_self').close();
//       //window.close();
//       console.log("Second Test");
   	  // $window.open('http://localhost:8081/','_self');
    	   
       window.close();
      
    };
    $scope.close = close;
	$window.onbeforeunload = close;
	


});