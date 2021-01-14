import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { OrderShopComponent } from './components/order-shop/order-shop.component';
import { DetailProductsComponent } from './components/detail-products/detail-products.component';
import { ShopComponent } from './shop.component';


const routes: Routes = [
  { path: 'list', component: ShopComponent },
  { path: 'list/:detailId', component: DetailProductsComponent },
  { path: 'order', component: OrderShopComponent },
  { path: '', redirectTo: 'list', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ShopRoutingModule { }
