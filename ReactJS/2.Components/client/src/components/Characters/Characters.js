import React from 'react';

import Roster from './Roster';
import Details from './Details';
import fetcher from '../../fetcher';

const ROSTER_ENPOINT = '/roster';
const DETAILS_ENDPOINT = '/character/';

export default class Characters extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            images: [],
            details: {
                name: null,
                id: null,
                url: null,
                bio: null
            }
        }
    }

    fetchRoster = () => fetcher.get(
        ROSTER_ENPOINT,
        data => this.setState({
            images: data.map(i => (
                { id: i.id, url: i.url }
            ))
        }))

    fetchDetails = id => fetcher.get(
        DETAILS_ENDPOINT + id,
        data => this.setState({ details: data })
    )

    selectCharacter = id => this.fetchDetails(id)

    componentDidMount = () => this.fetchRoster()

    render = () => (
        <div>
            <Roster images={this.state.images} select={this.selectCharacter}/>
            <Details {...this.state.details} />
        </div>
    )
}