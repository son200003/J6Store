// const app = angular.module("shopping-cart-app",[]);
//
// app.controller("shopping-cart-ctrl", function($scope, $http){
//
//     $scope.cart = {
//         items:[],
//
//         add(id){
//             alert("add ss")
//
//             var item = this.items.find(item => item.id == id);
//             if(item){
//                 item.qty++;
//                 this.saveToLocalStorage();
//             }
//             else{
//                 $http.get(`/rest/products/${id}`).then(resp =>
//                     {
//                         resp.data.qty = 1;
//                         this.items.push(resp.data);
//                         this.saveToLocalStorage();
//                     }
//                     )
//              }
//         },
//
//         remove(id){},
//
//         clear(){},
//
//         amt_of(item){},
//
//         get count(){
//             return this.items
//             .map(item => item.qty)
//             .reduce((total, qty) => total += qty, 0);
//         },
//
//         get amount(){
//             return this.items
//             .map(item => item.qty * item.price)
//             .reduce((total, qty) => total += qty, 0);
//         },
//
//         saveToLocalStorage(){
//             var json = JSON.stringify(angular.copy(this.items));
//             localStorage.setItem("cart", json);
//         }
//
//     }
// });

let app = angular.module("shopping-cart-app", []);

app.controller("shopping-cart-ctrl", function ($scope, $http) {

    $scope.cart = {
        items: [],
        // Thêm sản phẩm vào giỏ hàng
        add(id) {
            var item = this.items.find(item => item.id == id)
            if (item) {
                console.log(item);
                item.qty++;
                this.saveToLocalStorage();
            } else {
                $http.get(`/rest/products/${id}`).then(resp => {
                    resp.data.qty = 1;
                    this.items.push(resp.data);
                    this.saveToLocalStorage();
                })
            }
        },
        // Xóa sản phẩm khỏi giỏ hàng
        remove(id) {
            var index = this.items.findIndex(item => item.id == id);
            this.items.splice(index,1);
            this.saveToLocalStorage();
        },
        // Xóa sạch các mặt hàng trong giỏ hàng
        clear() {
            this.items =[];
            this.saveToLocalStorage();
        },
        // Tính thành tiền của 1 sản phẩm
        amt_of(item) {
        },

        // Tính tổng số lượng các mặt hàng trong giỏ
        get count() {
            return this.items
                .map(item => item.qty)
                .reduce((total,qty)=> total += qty,0);
        },

        // Tổng thành tiền các mặt hàng trong giỏ
        get amount() {

            return this.items
                .map(item => item.qty *item.price)
                .reduce((total, qty) => total += qty, 0);
        },
        // lưu giỏ hàng vào loacal store
        saveToLocalStorage() {
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart", json);
        },

        // Đọc giỏ hàng từ local storage
        loadFormLocalStorage(){
            var json = localStorage.getItem("cart");
            this.items = json ? JSON.parse(json) : [];
        }
    }

    $scope.cart.loadFormLocalStorage();
});