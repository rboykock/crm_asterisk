/*****Navigation****/
callCenterCRM.controller("NavCtrl",function($scope){
  //  navActive=='main';
})

/****DialedCtrl*****/
callCenterCRM.controller("DialedCtrl",function($scope,Dial,Dialed){
    $scope.activeTab='current_data_dial';
    $scope.diallist=Dial.getAll().$object;
    $scope.dialedlist=Dialed.getAll().$object;
    $scope.setActiveTab=function(tabToSet){
        $scope.activeTab=tabToSet;
    }
})

callCenterCRM.controller("DiallistCtrl",function($scope,Dial){
   // $scope.diallist=Dial.getAll().$object;
    $scope.clickDrop=function(dialId){
        Dial.drop(dialId).then(function(){
            $scope.diallist=Dial.getAll().$object;
        });
    }
});

callCenterCRM.controller("DialedlistCtrl",function($scope,Dialed){
    //$scope.dialedlist=Dialed.getAll().$object;
})

/****Index*****/
callCenterCRM.controller("IndexCtrl",function($scope){
    $scope.activeTab='customer';
    $scope.organizationName="";
    $scope.totalNotes;
    $scope.customerId=1;
    $scope.setActiveTab=function(tabToSet){
        $scope.activeTab=tabToSet;
    }
    $scope.setOrganizationName=function(name){
        $scope.organizationName=name;
    }
})

callCenterCRM.controller("CustomerData", function ($scope,$rootScope,Customers) {
    Customers.getOne($scope.$parent.customerId).then(function(result){
        $scope.customer =result;
        $scope.$parent.organizationName=result.organizationName;
        $scope.$parent.customerId=result.id;
        console.debug($scope.$parent);
    });
});

callCenterCRM.controller("CustomerNote", function ($scope,Notes,$rootScope) {
    $scope.noteView='note_list';
    $scope.notes = Notes.getAll($scope.$parent.customerId).$object;
    $rootScope.totalNotes=$scope.notes;
    $scope.clickAdd=function(){
        $scope.note={subject:'',description:''};
        setNoteView('note_form');
    }

    $scope.clickShow=function(noteId){
        $scope.note=Notes.getOne(noteId).$object;
        setNoteView('note_show');
    }
    $scope.clickDrop=function(noteId){
        Notes.drop(noteId).then(function(){
           $scope.notes=Notes.getAll($rootScope.customerId).$object;
            $rootScope.totalNotes=$scope.notes;
        });
    }

    $scope.clickSave=function(note){
        note.user_name='pupkin';
        Notes.add(note,$rootScope.customerId).then(function(){
           $scope.notes=Notes.getAll($rootScope.customerId).$object;
            $rootScope.totalNotes=$scope.notes;
           setNoteView('note_list');
        });
    }

    $scope.clickCancel=function(){
        setNoteView('note_list');
    }

    $scope.clickOk=function(){
        setNoteView('note_list');
    }

    setNoteView=function(view){
        $scope.noteView=view;
    }
});

callCenterCRM.controller("CustomersCtrl", function ($scope, $sce, $element,Customers,Campaigns) {
    var assignedampaignId;
    $scope.customersSelected=[];
    $scope.dropdownTitle=$sce.trustAsHtml('Виберіть компанію&#160;<span class="caret right"></span>');
    Customers.getAll().then(function(result){
        $scope.customers = result;
        $scope.panelTitle = $sce.trustAsHtml('Список клієнтів&#160;<span class="badge" data-toggle="tooltip" data-placement="top" title="Загальна кількість">'+result.length+'</span>');
    });

    $scope.customerView = "customer_list";

    $scope.campaigns = Campaigns.getAll().$object;

    $scope.clickAdd = function () {
        setCustomerView('customer_form');
        $scope.panelTitle = $sce.trustAsHtml("Новий клієнт");
        $scope.customer = {"organizationName": "", "contactPerson": "", "phoneNumber": "", "email": "", "address": ""};
    }

    $scope.clickDrop = function (customerId) {
        Customers.drop(customerId).then(function () {
            Customers.getAll().then(function(result){
                $scope.customers = result;
                $scope.panelTitle = $sce.trustAsHtml('Список клієнтів&#160;<span class="badge" data-toggle="tooltip" data-placement="top" title="Загальна кількість">'+result.length+'</span>');
            });
        })
    }

    //what is that for?
    $scope.clickShow = function (customerId) {
        $scope.panelTitle = $sce.trustAsHtml("Клієнт: <strong>" + Customers.getOne(customerId).organizationName + "</strong>");
        $scope.customer = Customers.getOne(customerId).$object;
        setCustomerView('customer_show');
    }
    $scope.clickEdit = function (customerId) {
        setCustomerView('customer_form');
        var customerOrganizationName;
        Customers.getOne(customerId).then(function (customer) {
            $scope.customer = customer;
            customerOrganizationName = customer.organizationName;
            $scope.panelTitle = $sce.trustAsHtml("Організація: <strong>" + customerOrganizationName + "</strong>");
        })
    }
    //what is that for?
    $scope.clickAssign = function () {
        var assigned=[];
        angular.forEach($scope.customers,function(customer,key){
            if(customer.isChecked){
                assigned.push(customer.phoneNumber);
            }
        });
        Customers.assigned(assigned,assignedampaignId).then(function(){
            angular.forEach($scope.customers,function(customer,key){
                if(customer.isChecked){
                    customer.isChecked=false;
                }
            });
        })
    }

    $scope.clickSave = function (customer) {
        if (customer.id) {
            Customers.update(customer).then(function () {
                $scope.customers = Customers.getAll().$object;
            });
        } else {
            Customers.add(customer).then(function (result) {
                Customers.getAll().then(function(result){
                    $scope.customers = result;
                    $scope.panelTitle = $sce.trustAsHtml('Список клієнтів&#160;<span class="badge" data-toggle="tooltip" data-placement="top" title="Загальна кількість">'+result.length+'</span>');
                });
                setCustomerView('customer_list');
            });
        }
    }

    $scope.clickCansel = function () {
        Customers.getAll().then(function(result){
            $scope.customers = result;
            $scope.panelTitle = $sce.trustAsHtml('Список клієнтів&#160;<span class="badge" data-toggle="tooltip" data-placement="top" title="Загальна кількість">'+result.length+'</span>');
        });
        setCustomerView('customer_list');
    }

    setCustomerView = function (view) {
        $scope.customerView = view;
    }

    $scope.clickChoose=function(campaign){
       //var dropdown_header = angular.element($element.'dropdown-header');
        $scope.dropdownTitle=$sce.trustAsHtml(campaign.name+'&#160;<span class="caret right"></span>');
        assignedampaignId=campaign.id;
    }
/*
    $(".dropdown-menu li a").click(function(){
        var selText = $(this).text();
        var id=$(this).attr("id");
        $(this).parents('.btn-group').find('.dropdown-toggle').attr("id",id);
        $(this).parents('.btn-group').find('.dropdown-toggle').html(selText+' <span class="caret right"></span>');
    });*/
});

/*** Campaings controller ****/
callCenterCRM.controller("CampaingsCtrl",function($scope,$sce,Campaigns,Users){

    Campaigns.getAll().then(function(result){
        $scope.campaigns=result;
        $scope.panelTitle=$sce.trustAsHtml('Список компаній&#160;<span class="badge" data-toggle="tooltip" data-placement="top" title="Загальна кількість">'+result.length+'</span>');
    });

    $scope.campaingView="campaings_list"

    $scope.assignUsers=function(){
        angular.forEach(this.assignedExt,function(extension,key){
            angular.forEach($scope.users,function(user,key){
                if(user.extension===extension){
                    console.debug(user);
                    $scope.assignedUsers.push(user);
                    $scope.users.splice(key,1);
                }
            });
        });
    }

    $scope.unassignUsers=function(){
        angular.forEach(this.assignExt,function(extension,key){
            angular.forEach($scope.assignedUsers,function(user,key){
                if(user.extension===extension){
                    console.debug(user);
                    $scope.users.push(user);
                    $scope.assignedUsers.splice(key,1);
                }
            });
        });
    }

    $scope.clickAdd=function(){
        $scope.assignedUsers=[];
        $scope.panelTitle=$sce.trustAsHtml('Нова компанія');
        $scope.users=Users.getAll().$object;
        setCampaignView("campaings_form");
    }

    $scope.clickEdit=function(campaingId){
        $scope.assignedUsers=[];
        $scope.users=Users.getAll().$object;
        Campaigns.getOne(campaingId).then(function(result){
            $scope.campaing=result;
            angular.forEach(result.assignedExt,function(extension,key){
                console.debug($scope.users);
                angular.forEach($scope.users,function(user,key){
                    if(user.extension==extension){
                        $scope.assignedUsers.push(user);
                        $scope.users.splice(key,1);
                    }
                })
            })
        });

        setCampaignView("campaings_form");
    }

    $scope.clickSave=function(){
        var assignedExt=[];
        angular.forEach(this.assignedUsers,function(user,key){
            assignedExt.push(user.extension);
        });
        this.campaing.assignedExt=assignedExt;
        if(this.campaing.id){
            Campaigns.update(this.campaing).then(function(){
                $scope.campaigns=Campaigns.getAll().$object;
            });
        }else{
            Campaigns.add(this.campaing,assignedExt).then(function(){
                Campaigns.getAll().then(function(result){
                    $scope.campaigns=result;
                    $scope.panelTitle=$sce.trustAsHtml('Список компаній&#160;<span class="badge" data-toggle="tooltip" data-placement="top" title="Загальна кількість">'+result.length+'</span>');
                });
                $scope.campaingView="campaings_list"
            });
        }
    }

    $scope.clickDrop=function(campaingId){
        Campaigns.drop(campaingId).then(function(){
            Campaigns.getAll().then(function(result){
                $scope.campaigns=result;
                $scope.panelTitle=$sce.trustAsHtml('Список компаній&#160;<span class="badge" data-toggle="tooltip" data-placement="top" title="Загальна кількість">'+result.length+'</span>');
            });
        });
    }

    $scope.clickStatus=function(campaingId,status){
        status=(status=='START')?'STOP':'START';
        Campaigns.status(campaingId,status).then(function(){
            $scope.campaigns=Campaigns.getAll().$object;
        });
    }

    $scope.clickShowUsers=function(campaing){
        $scope.users=Campaigns.getUsers(campaing.id).then(function(result){
            $scope.users=result;
            $scope.campaingId=campaing.id;
            $scope.panelTitle=$sce.trustAsHtml('Список операторів на компанію <strong>'+campaing.name+'</strong>');
        });

        setCampaignView('campaigns_list_users');
    }

    $scope.clickShowCustomers=function(campaing){

        $scope.customers=Campaigns.getCustomers(campaing.id).$object;
        $scope.campaignId=campaing.id;
        $scope.panelTitle=$sce.trustAsHtml('Список клієнтів на обдзвін по компанії <strong>'+campaing.name+'</strong>');
        setCampaignView('campaigns_list_customers');
    }

    $scope.clickCancel=function(){
        Campaigns.getAll().then(function(result){
            $scope.campaigns=result;
            $scope.panelTitle=$sce.trustAsHtml('Список компаній&#160;<span class="badge" data-toggle="tooltip" data-placement="top" title="Загальна кількість">'+result.length+'</span>');
        });
        $scope.campaingView="campaings_list"
    }

    $scope.clickDropUserFromCampaign=function(extention,campaignId){
        Campaigns.dropUser(extention,campaignId).then(function(){
            $scope.users=Campaigns.getUsers(campaignId).$object;
        });
    }

    $scope.clickDropCustomerFromCampaign=function(customer,campaignId){
        Campaigns.dropCustomer(customer.customerId,campaignId).then(function(){
            $scope.customers=Campaigns.getCustomers(campaignId).$object;
        })
    }

    setCampaignView=function(view){
        $scope.campaingView=view;
    }
});

/**** Users controller ****/
callCenterCRM.controller("UsersCtrl",function($scope,$sce,$element,Users){
    $scope.usersView="users_list";
    Users.getAll().then(function(result){
        $scope.users=result;
        $scope.panelTitle=$sce.trustAsHtml('Список користувачів&#160;<span class="badge" data-toggle="tooltip" data-placement="top" title="Загальна кількість">'+result.length+'</span>');
    });


    $scope.clickAdd=function(){
        setUsersView('users_form');
        $scope.panelTitle=$sce.trustAsHtml("Новий користувача");
        $scope.user= {"username":"","login":"","password":"","extension":"","role":"none","email":""};
    }

    $scope.clickDrop=function(userId){
        Users.drop(userId).then(function(){
            Users.getAll().then(function(result){
                $scope.users=result;
                $scope.panelTitle=$sce.trustAsHtml('Список користувачів&#160;<span class="badge" data-toggle="tooltip" data-placement="top" title="Загальна кількість">'+result.length+'</span>');
            });
        });
    }

    $scope.clickEdit=function(userId){
        setUsersView('users_form');
        var userFullName;
        Users.getOne(userId).then(function(user){
            $scope.user=user;
            userFullName=user.fullName;
            $scope.panelTitle=$sce.trustAsHtml("Користувач: <strong>"+userFullName+"</strong>");
        });
    }

    $scope.clickSave=function(user){
        if(user.id) {
            Users.update(user).then(function () {
                $scope.users=Users.getAll().$object;
            });
        }else{
            Users.add(user).then(function(){
                Users.getAll().then(function(result){
                    $scope.users=result;
                    $scope.panelTitle=$sce.trustAsHtml('Список користувачів&#160;<span class="badge" data-toggle="tooltip" data-placement="top" title="Загальна кількість">'+result.length+'</span>');
                });
                setUsersView('users_list');
            });
        }
    }

    $scope.clickCansel=function(){
        Users.getAll().then(function(result){
            $scope.users=result;
            $scope.panelTitle=$sce.trustAsHtml('Список користувачів&#160;<span class="badge" data-toggle="tooltip" data-placement="top" title="Загальна кількість">'+result.length+'</span>');
        });
        setUsersView('users_list');
    }

    setUsersView=function(view){
        $scope.usersView=view;
    }
});
