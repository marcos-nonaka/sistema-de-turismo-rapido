import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import Home from "./components/Home";
import About from "./components/About";
import Itinerary from "./components/Itinerary";

function App() {
  return (
    <Router>
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/quem-somos' element={<About />} />
        <Route path='/pesquisar-roteiro' element={<Itinerary />} />
      </Routes>
    </Router>
  );
}

export default App;
