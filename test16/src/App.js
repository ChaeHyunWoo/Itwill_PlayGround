import React from 'react';
import { Music, Plan, Todos } from './component';

const App = () => {
  return (
    <div>
      <Todos/>
      <Music/>
      <hr/>
      <Plan/>
    </div>
  );
};

export default App;