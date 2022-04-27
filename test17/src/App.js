import React from 'react';
import { Link } from 'react-router-dom';
import { Route, Switch } from 'react-router-dom';
import Main from './router6/Main';
import NotProducts from './router6/NotProducts';
import ProductDetail from './router6/ProductDetail';
import Products from './router6/Products';


const App = () => {

  return (    
    <div>
      <ul>
        <li><Link to='/'>Home</Link></li>
        <li><Link to='/products'>Products</Link></li>
      </ul>
      <Switch>
        <Route path={['/','/main']}exact><Main/></Route>
        <Route path='/products' exact><Products/></Route>
        <Route path='/products/:productID' exact><ProductDetail/></Route>
        <Route path='*'><NotProducts/></Route>
      </Switch>

               
    </div>
  );
};

export default App;