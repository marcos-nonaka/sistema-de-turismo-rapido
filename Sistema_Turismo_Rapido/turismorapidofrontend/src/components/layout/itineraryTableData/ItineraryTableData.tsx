import React, { useEffect, useState } from 'react'
import axios, { AxiosError } from 'axios'
import { getUserLocalStorage } from '../../../store/util'

function ItineraryTableData(){
	const [dataItineraries, setDataItineraries] = useState<any[]>()
	const token = getUserLocalStorage().token
	const userID = getUserLocalStorage().user_id
	console.log(userID)
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
			setDataItineraries(response.data)
			console.log(response.data)
		})
		
	}, []);
	
	//console.log(dataItineraries)
  return (
		<table className={'table'}>
			<thead>
				<tr>
					<th>Cidade</th>
					<th>Atrações</th>
					<th>Hoteis</th>
					<th>Restaurantes</th>
				</tr>
			</thead>
			<tbody>
				{dataItineraries?.map((item) => {
					return <tr key={item.idRoteiro}><td>{item.cidade.name}</td><td>{'{}'}</td><td>{'{}'}</td><td>{'{}'}</td></tr>
				})}
			</tbody>
		</table>
  )
}

export default ItineraryTableData
