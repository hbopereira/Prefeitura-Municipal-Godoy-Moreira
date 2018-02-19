angular.module('JWTDemoApp')

   .config(function($stateProvider, $urlRouterProvider) {
	
	// the ui router will redirect if a invalid state has come.
	$urlRouterProvider.otherwise('/pagina-inicial');
	// parent view - navigation state
	$stateProvider.state('nav', {
		abstract : true,
		url : '',
		views : {
			'nav@' : {
				templateUrl : 'app/views/nav.html',
				controller : 'NavController'
			}
		}
	}).state('login', {
		parent : 'nav',
		url : '/login',
		views : {
			'content@' : {
				templateUrl : 'app/views/login.html',
				controller : 'LoginController'
			}
		}
	}).state('new-machine', {
		parent : 'nav',
		url : '/novo-maquinario',
		data : {
		    roles: ['ADMIN','AGRICULTURA']
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/machine/machine.html',
				controller : 'MachineController'
			}
		}
	}).state('new-athlete', {
		parent : 'nav',
		url : '/novo-atleta',
		data : {
		    roles: ['ADMIN','ESPORTE']
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/athlete/athlete.html',
				controller : 'AthleteController'
			}
		}
	}).state('registered-athletes', {
		parent : 'nav',
		url : '/atletas-cadastrados',
		data : {
			permissions :{
				  only:	['ADMIN','ESPORTE','SUBORDINADO_R_ESPORTE']	
		    } 
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/athlete/registered-athletes.html',
				controller : 'AthleteController'
			}
		}
	}).state('new-producer', {
		parent : 'nav',
		url : '/novo-produtor',
		data : {
			permissions :{
				  only:	[ 'ADMIN' , 'AGRICULTURA']	
		    } 
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/producer/producer.html',
				controller : 'ProducerController'
			}
		}
	}).state('registered-producers', {
		parent : 'nav',
		url : '/produtores-cadastrados',
		data : {
			roles: ['ADMIN','AGRICULTURA']
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/producer/registered-producers.html',
				controller : 'ProducerController'
			}
		}
	}).state('new-order', {
		parent : 'nav',
		url : '/novo-pedido',
		data : {
			permissions :{
				  only:	[ 'ADMIN' , 'AGRICULTURA']	
		    } 
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/order/order.html',
				controller : 'OrderController'
			}
		}
	}).state('registered-orders', {
		parent : 'nav',
		url : '/pedidos-cadastrados',
		data : {
			permissions :{
				  only:	[ 'ADMIN' , 'AGRICULTURA']	
		    } 
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/order/registered-orders.html',
				controller : 'OrderController'
			}
		}
	}).state('registered-activities', {
		parent : 'nav',
		url : '/atividades-cadastradas',
		data : {
			permissions :{
				  only:	['ADMIN','AGRICULTURA']	
		    } 
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/activity/registered-activities.html',
				controller : 'ActivityController'
			}
		}
	}).state('register', {
		parent : 'nav',
		url : '/registrar-usuario',
		views : {
			'content@' : {
				templateUrl : 'app/views/register.html',
				controller : 'RegisterController'
			}
		}
	}).state('new-user', {
		parent : 'nav',
		url : '/novo-usuario',
		data : {
			role : 'ADMIN'
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/user/user.html',
				controller : 'UsersController'
			}
		}
	}).state('registered-users', {
		parent : 'nav',
		url : '/usuarios-cadastrados',
	    data : {
		   role: 'ADMIN'
	    },
		views : {
			'content@' : {
				templateUrl : 'app/views/user/registered-users.html',
				controller : 'UsersController'
			}
		}
	}).state('home', {
		parent : 'nav',
		url : '/pagina-inicial',
		views : {
			'content@' : {
				templateUrl : 'app/views/home.html',
				controller : 'HomeController'
			}
		}
	}).state('page-not-found', {
		parent : 'nav',
		url : '/page-not-found',
		views : {
			'content@' : {
				templateUrl : 'app/views/page-not-found.html',
				controller : 'PageNotFoundController'
			}
		}
	}).state('access-denied', {
		parent : 'nav',
		url : '/acesso-negado',
		views : {
			'content@' : {
				templateUrl : 'app/views/access-denied.html',
				controller : 'AccessDeniedController'
			}
		}
	}).state('new-activity', {
		parent : 'nav',
		url : '/nova-atividade',
		data : {
			permissions :{
				  only:	['ADMIN','AGRICULTURA']	
		    } 
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/activity/activity.html',
				controller : 'ActivityController'
			}
		}
	}).state('new-attendance-agriculture', {
		parent : 'nav',
		url : '/novo-atendimento-agricultura',
		data : {
			permissions :{
				  only:	['ADMIN','AGRICULTURA']	
		    } 
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/attendanceAgriculture/attendance-agriculture.html',
				controller : 'AttendanceAgricultureController'
			}
		}
	}).state('new-attendance-sport', {
		parent : 'nav',
		url : '/novo-atendimento-esporte',
		data : {
			permissions :{
				  only:	['ADMIN', 'ESPORTE']	
		    } 
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/attendanceSport/attendance-sport.html',
				controller : 'AttendanceSportController'
			}
		}
	}).state('attendancies-progress-agriculture', {
		parent : 'nav',
		url : '/atendimentos-cadastrados-agricultura',
		data : {
			roles: ['ADMIN','AGRICULTURA']	    
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/attendanceAgriculture/attendancies-progress-agriculture.html',
				controller : 'AttendanceAgricultureController'
			}
		}
	}).state('report-order-status', {
		parent : 'nav',
		url : '/pedidos-status',
		data : {
		    roles: ['SUBORDINADO_R_AGRICULTURA','ADMIN','AGRICULTURA']
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/order/report-order-status.html',
				controller : 'OrderController'
			}
		}
	}).state('report-athlete-category', {
		parent : 'nav',
		url : '/atletas-categoria',
		data : {
		    roles: ['SUBORDINADO_R_AGRICULTURA','ADMIN','AGRICULTURA']
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/athlete/report-athlete-category.html',
				controller : 'AthleteController'
			}
		}
	}).state('report-athlete-date-born', {
		parent : 'nav',
		url : '/atletas-data-nascimento',
		data : {
		    roles: ['SUBORDINADO_R_AGRICULTURA','ADMIN','AGRICULTURA']
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/athlete/report-athlete-date-born.html',
				controller : 'AthleteController'
			}
		}
	}).state('report-producer-with-family-agriculture', {
		parent : 'nav',
		url : '/produtores-agricultura-familiar',
		data : {
		    roles: ['SUBORDINADO_R_AGRICULTURA','ADMIN','AGRICULTURA']
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/producer/report-producer-with-family-agriculture.html',
				controller : 'ProducerController'
			}
		}
	}).state('report-producer-not-family-agriculture', {
		parent : 'nav',
		url : '/produtores-comuns',
		data : {
		    roles: ['SUBORDINADO_R_AGRICULTURA','ADMIN','AGRICULTURA']
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/producer/report-producer-not-family-agriculture.html',
				controller : 'ProducerController'
			}
		}
	}).state('report-producer-act-region', {
		parent : 'nav',
		url : '/produtores-atividade-regiao',
		data : {
		    roles: ['SUBORDINADO_R_AGRICULTURA','ADMIN','AGRICULTURA']
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/producer/report-producer-act-region.html',
				controller : 'ProducerController'
			}
		}
	}).state('report-attendance-date-period', {
	parent : 'nav',
	url : '/atendimento-periodo-data',
	data : {
	    roles: ['SUBORDINADO_R_AGRICULTURA','ADMIN','AGRICULTURA']
	},
	views : {
		'content@' : {
			templateUrl : 'app/views/attendanceAgriculture/report-attendance-date-period.html',
			controller : 'AttendanceController'
		}
	}
  }).state('report-attendance-agriculture-status', {
		parent : 'nav',
		url : '/atendimento-status-conclusao-agricultura',
		data : {
		    roles: ['SUBORDINADO_R_AGRICULTURA','ADMIN','AGRICULTURA']
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/attendanceAgriculture/report-attendance-agriculture-status.html',
				controller : 'AttendanceAgricultureController'
			}
		}
	  }).state('attendancies-finally-agriculture', {
		parent : 'nav',
		url : '/atendimentos-finalizados-agricultura',
		data : {
		    roles: ['SUBORDINADO_R_AGRICULTURA','ADMIN','AGRICULTURA']
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/attendanceAgriculture/attendancies-finally-agriculture.html',
				controller : 'AttendanceAgricultureController'
			}
		}
  }).state('attendancies-not-finish-agriculture', {
		parent : 'nav',
		url : '/atendimentos-nao-concluidos-agricultura',
		data : {
		    roles: ['SUBORDINADO_R_AGRICULTURA','ADMIN','AGRICULTURA']
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/attendanceAgriculture/attendancies-not-finish-agriculture.html',
				controller : 'AttendanceAgricultureController'
			}
		}
  }).state('historic-attendancies-agriculture', {
		parent : 'nav',
		url : '/historico-atendimentos-agricultura',
		data : {
		    role: 'ADMIN'
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/attendanceAgriculture/historic-attendancies-agriculture.html',
				controller : 'AttendanceAgricultureController'
			}
		}
  }).state('historic-registered-orders', {
		parent : 'nav',
		url : '/historico-pedidos-registrados',
		data : {
		    role: 'ADMIN'
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/order/historic-registered-orders.html',
				controller : 'OrderController'
			}
		}
  }).state('historic-attendancies-sport', {
		parent : 'nav',
		url : '/historico-atendimentos-esporte',
		data : {
		    role: 'ADMIN'
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/attendanceSport/historic-attendancies-sport.html',
				controller : 'AttendanceSportController'
			}
		}
  }).state('report-attendance-sport-status', {
		parent : 'nav',
		url : '/atendimento-status-conclusao-esporte',
		data : {
		    roles: ['SUBORDINADO_R_AGRICULTURA','ADMIN','AGRICULTURA']
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/attendanceSport/report-attendance-sport-status.html',
				controller : 'AttendanceSportController'
			}
		}
	  }).state('register-people-agriculture', {
		parent : 'nav',
		url : '/registrar-pessoa-agricultura',
		data : {
		    roles: ['SUBORDINADO_R_AGRICULTURA','ADMIN','AGRICULTURA']
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/people/register-people-agriculture.html',
				controller : 'PeopleController'
			}
		}
 }).state('registered-peoples-agriculture', {
		parent : 'nav',
		url : '/pessoas-registradas-agricultura',
		data : {
		    roles: ['SUBORDINADO_R_AGRICULTURA','ADMIN','AGRICULTURA']
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/people/registered-peoples-agriculture.html',
				controller : 'PeopleController'
			}
		}
 }).state('register-people-sport', {
		parent : 'nav',
		url : '/registrar-pessoa-esporte',
		data : {
		    roles: ['SUBORDINADO_R_AGRICULTURA','ADMIN','AGRICULTURA']
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/people/register-people-sport.html',
				controller : 'PeopleController'
			}
		}
 }).state('registered-peoples-sport', {
		parent : 'nav',
		url : '/pessoas-registradas-esporte',
		data : {
		    roles: ['SUBORDINADO_R_AGRICULTURA','ADMIN','AGRICULTURA']
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/people/registered-peoples-sport.html',
				controller : 'PeopleController'
			}
		}
 }).state('attendancies-progress-sport', {
		parent : 'nav',
		url : '/atendimentos-andamento-esporte',
		data : {
		    roles: ['SUBORDINADO_R_AGRICULTURA','ADMIN','AGRICULTURA']
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/attendanceSport/attendancies-progress-sport.html',
				controller : 'AttendanceSportController'
			}
		}
  }).state('attendancies-not-finish-sport', {
		parent : 'nav',
		url : '/atendimentos-nao-concluido-esporte',
		data : {
		    roles: ['SUBORDINADO_R_AGRICULTURA','ADMIN','AGRICULTURA']
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/attendanceSport/attendancies-not-finish-sport.html',
				controller : 'AttendanceSportController'
			}
		}
  }).state('attendancies-finally-sport', {
		parent : 'nav',
		url : '/atendimentos-finalizados-esporte',
		data : {
		    roles: ['SUBORDINADO_R_AGRICULTURA','ADMIN','AGRICULTURA']
		},
		views : {
			'content@' : {
				templateUrl : 'app/views/attendanceSport/attendancies-finally-sport.html',
				controller : 'AttendanceSportController'
			}
		}
	  })
}).filter('startFrom', function(){
    	return function(data, start){
    		if (!data || !data.length) { return; }
            start = +start;
    		return data.slice(start);
    	}
    });

   