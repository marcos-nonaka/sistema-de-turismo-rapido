import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import Home from "./components/Home";
import About from "./components/About";
import SearchItinerary from "./components/SearchItinerary";
import TalkWithUs from "./components/TalkWithUs";
import Login from "./components/Login";
import Register from "./components/Register";
import Itinerary from "./components/Itinerary";

function App() {
  return (
    <Router>
      <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/quem-somos' element={<About />} />
        <Route path='/pesquisar-roteiro' element={<SearchItinerary />} />
        <Route path='/fale-conosco' element={<TalkWithUs />} />
        <Route path='/login' element={<Login />} />
        <Route path='/cadastre-se' element={<Register />} />
        <Route path='/roteiro' element={<Itinerary />} />
      </Routes>
    </Router>
  );
}

export default App;
