myApp.controller("HomeCtrl", function ($scope, $http){
    console.log("test");
    $http.get("http://localhost:8090/formations")
    .then((response) => {
        $scope.formations = response.data;
    });
});
myApp.controller("dashboardCtrl", function ($scope, $http) {
    console.log("heho")
    $http.get("http://localhost:8090/formations")
    .then((response) => {
        $scope.formations = response.data;
        $scope.nbFormations=$scope.formations.length;
    });
});