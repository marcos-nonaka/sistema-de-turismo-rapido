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
      <div id="main">
        <Slider />
        <Destinations />
      </div>
      <Footer />
    </>
  );
}

export default Home;
