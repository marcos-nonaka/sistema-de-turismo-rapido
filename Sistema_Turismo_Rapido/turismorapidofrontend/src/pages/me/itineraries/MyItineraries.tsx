import React, {useEffect, useContext, useState} from 'react'
import axios, { AxiosError } from 'axios'
import { Meheader, Menav, Menavgist, Footer, NoItinerary, ItineraryTableData } from '../../../components'
import Alertify from "../../../components/alertify/Alertify";
import { useNavigate } from 'react-router-dom'
import { getUserLocalStorage } from '../../../store/util'
//import error from "../../../assets/img/error.png";

function MyItineraries(){
	const userData = getUserLocalStorage()
	const token = getUserLocalStorage().token
	const userID = getUserLocalStorage().user_id
	const [data, setData] = useState<any[]>()
	const navigate = useNavigate()
	const [isAvaliable, setIsAvaliable] = useState(false);
	//const [dataItineraries, setDataItineraries] = useState<any[]>()

	useEffect(() => {
		document.body.classList.remove('bg-internas-login');
		document.body.classList.add('bg-internas-dashboard');
		
		//carregar requisicao axios get

        const headers = {
            headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json',
				'Authorization': 'Basic ' + token,
            }
        }

		axios.get('http://localhost:3000/roteiros?name='+userID, headers).then(response => {
		console.log(response.status)
			if(response.status == 204){
				setIsAvaliable(false)
			}else{
				setIsAvaliable(true)
			}
		})
		
	}, []);


    return(
		<>
		<Meheader />
		<div id="main">
			<div className="container">				
				<div className="row">
					<div className="col-md-3 col-sm-12">
						{ userData.role == 'ROLE_TURISTA' ? <Menav /> : <Menavgist /> }
					</div>
					<div className="col-md-9 col-sm-12">
						<h2 className="h2 fw-bold mb-2">Meus roteiros</h2>
						<p className="mb-4">Administre sua experiência na Quatour</p>
				
						<div className="dashboard-content rounded-4 bg-white p-5 mb-5">
							{isAvaliable ? <ItineraryTableData /> : <NoItinerary />}
							
						</div>
					</div>
				</div>

			</div>
		</div>
		
		<Footer />
		</>
	)

}

export default MyItineraries;