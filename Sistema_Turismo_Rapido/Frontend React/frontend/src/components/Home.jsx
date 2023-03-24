import React from "react";

import "../assets/css/style.css";

import Navbar from "./Navbar";
import Slider from "./Slider";
import Destinations from "./Destinations";
import Footer from "./Footer";

function Home() {
  return (
    <>
      <Navbar />
      <Slider />
      <Destinations />
      <Footer />
    </>
  );
}

export default Home;
