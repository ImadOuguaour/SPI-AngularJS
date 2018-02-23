var myApp = angular.module("myApp", ["ui.router"]);

myApp.config(($stateProvider, $urlRouterProvider) => {
    $stateProvider.state('home', {
        views: {
            "index": {
                templateUrl: "views/home.html",
                controller: "HomeCtrl"
            }
        }
    });
    $stateProvider.state('dashboard', {
        url: "/",
        parent: "home",
        views: {
            "home": {
                templateUrl: "views/dashboard.html",
                controller: "dashboardCtrl"
            }
        }
    });
    $stateProvider.state('formations', {
        parent: "home",
        url: '/formations',
        views: {
            "home": {
                templateUrl: "views/formations.html",
                controller: "FormationCtrl"
            }
        }
    });
    $stateProvider.state('detailFormation', {
        parent: "formations",
        url: '/detailFormation/:id',
        views: {
            "formation": {
                templateUrl: "views/detailFormation.html",
                controller: "detailFormationCtrl"
            }
        }
    });
    $stateProvider.state('ajoutFormation', {
        parent: "formations",
        url: '/newFormation',
        views: {
            "formation": {
                templateUrl: "views/ajoutFormation.html",
                controller: "ajoutFormationCtrl"
            }
        }
    });
    $stateProvider.state('modifierFormation', {
        parent: "formations",
        url: '/editFormation/:id',
        views: {
            "formation": {
                templateUrl: "views/modifierFormation.html",
                controller: "modifierFormationCtrl"
            }
        }
    });
    $stateProvider.state('enseignants', {
        parent: "home",
        url: '/enseignants',
        views: {
            "home": {
                templateUrl: "views/enseignants.html",
                controller: "EnseignantCtrl"
            }
        }
    });
    $stateProvider.state('ajoutEnseignant', {
        parent: "enseignants",
        url: '/newEnseignant',
        views: {
            "enseignant": {
                templateUrl: "views/ajoutEnseignant.html",
                controller: "ajoutEnseignantCtrl"
            }
        }
    });
    $stateProvider.state('modifierEnseignant', {
        parent: "enseignants",
        url: '/editEnseignant/:id',
        views: {
            "enseignant": {
                templateUrl: "views/modifierEnseignant.html",
                controller: "modifierEnseignantCtrl"
            }
        }
    });
    $stateProvider.state('detailEnseignant', {
        parent: "enseignants",
        url: '/detailEnseignant/:id',
        views: {
            "enseignant": {
                templateUrl: "views/detailEnseignant.html",
                controller: "detailEnseignantCtrl"
            }
        }
    });
    $urlRouterProvider.otherwise('/');
});
