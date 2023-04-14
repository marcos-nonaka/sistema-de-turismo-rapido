import React from "react";
import { Navbar, Navuser, Slider, Content, Footer } from '../../components'
import { getUserLocalStorage } from '../../store/util'

function Home() {
	const userData = getUserLocalStorage() != null ? getUserLocalStorage() : ''
	
    return(
		<div>
			{ userData.username ? <Navuser /> : <Navbar /> }
			<Slider />
			<Content />
			<Footer />
		</div>	
	)

}

export default Home;