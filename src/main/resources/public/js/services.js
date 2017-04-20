callCenterCRM.factory('Users',function(Restangular){
   return {
      getAll:function(){
         return Restangular.all('users').getList();
      },
      drop:function(userId){
         return Restangular.one("users",userId).remove();
      },
      getOne:function(userId){
         return Restangular.one("users",userId).get();
      },
      update:function(user){
         return Restangular.one('users').customPUT(user.plain());
      },
      add:function(user){
         return Restangular.one('users').customPOST(user);
      }
   }
});

callCenterCRM.factory('Notes',function(Restangular){
   return {
      getAll:function(customerId){
         return Restangular.one('notes').one('customer').getList(customerId);
      },
      getOne:function(noteId){
         return Restangular.one('notes',noteId).get();
      },
      drop:function(noteId){
         return Restangular.one('notes',noteId).remove();
      },
      add:function(note,customerId){
         return Restangular.one('notes').one('customer',customerId).customPOST(note);
      }
   }
});

callCenterCRM.factory('Customers',function(Restangular){
   return {
      getAll:function(){
         return Restangular.all('customers').getList();
      },
      drop:function(customerId){
         return Restangular.one("customers",customerId).remove();
      },
      getOne:function(customerId){
         return Restangular.one("customers",customerId).get();
      },
      update:function(customer){
         return Restangular.one('customers').customPUT(customer.plain());
      },
      add:function(customer){
         return Restangular.one('customers').customPOST(customer);
      },
      assigned:function(assigned,campaignId){
         return Restangular.all('customers').one('campaign',campaignId).customPOST(assigned,'assigned');
      }
   }
});

callCenterCRM.factory('Campaigns',function(Restangular){
      return {
         getAll: function () {
            return Restangular.all('campaigns').getList();
         },
         add:function(campaing){
            return Restangular.one('campaigns').customPOST(campaing);
         },
         drop:function(campaingId){
            return Restangular.one("campaigns",campaingId).remove();
         },
         status:function(campaingId,status){
            return Restangular.one('campaigns',campaingId).customPUT(undefined,'status',{'status':status});
         },
         getOne:function(campaignId){
            return Restangular.one('campaigns',campaignId).get();
         },
         update:function(campaing){
            return Restangular.one('campaigns').customPUT(campaing.plain());
         },
         getUsers:function(campaignId){
            return Restangular.one('campaigns',campaignId).getList('users');
         },
         dropUser:function(extension,campaignId){
            return Restangular.one('campaigns',campaignId).one('extension',extension).remove();
         },
         getCustomers:function(campaignId){
            return Restangular.one('campaigns',campaignId).getList('customers');
         },
         dropCustomer:function(customerId,campaignId){
            return Restangular.one('campaigns',campaignId).one('customer',customerId).remove();
         }
      }
});

callCenterCRM.factory('Dialed',function(Restangular){
   return {
      getAll:function(){
         return Restangular.all('dialedlist').getList();
      }
   }
});

callCenterCRM.factory('Dial',function(Restangular){
   return {
      getAll: function () {
         return Restangular.all('diallist').getList();
      },
      drop:function(dialId){
         return Restangular.one('diallist',dialId).remove();
      }
   }
})