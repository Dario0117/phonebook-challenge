import React from 'react';
import phonebook from './phonebook.png';
import './App.css';

class App extends React.Component {
  state = {
    contacts: [],
    searchTerm: "",
    searchResult: [],
    firstName: "",
    lastName: "",
    phone: "",
  }

  loadContacts = () => {
    fetch("http://localhost:8080/contact")
      .then(res => res.json())
      .then(contacts => {
        this.setState({
          contacts
        })
      })
  }

  componentDidMount() {
    this.loadContacts()
  }

  handleSearch = (e) => {
    e.preventDefault()
    fetch(`http://localhost:8080/contact/search?q=${this.state.searchTerm}`)
    .then(res => res.json())
    .then(contacts => {
      this.setState({
        searchResult: contacts
      })
    })
  }

  handleAdd = (e) => {
    e.preventDefault()
    fetch("http://localhost:8080/contact", {
      method: 'POST',headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        firstName: this.state.firstName,
        lastName: this.state.lastName,
        phone: this.state.phone,
      })
    })
    .then(res => res.json())
    .then(contacts => {
      this.setState({
        searchResult: contacts
      })
      this.loadContacts()
    })
  }

  handleSearchInput = (e) => {
    e.preventDefault()
    this.setState({
      searchTerm: e.target.value
    })
  }

  handleFirstName = (e) => {
    e.preventDefault()
    this.setState({
      firstName: e.target.value
    })
  }

  handleLastName = (e) => {
    e.preventDefault()
    this.setState({
      lastName: e.target.value
    })
  }

  handlePhone = (e) => {
    e.preventDefault()
    this.setState({
      phone: e.target.value
    })
  }

  render() {
    return (
      <div className="container">
        <div className="pure-g">
          <div className="pure-u-1">
            <div className="header">
              <img className="logo" alt="logo" src={phonebook} />
              <p>v 1.0</p>
            </div>
          </div>
        </div>
        <div className="pure-g">
          <div className="pure-u-sm-1 pure-u-1-3">
            <div className="box">
              <h2><i className="fa fa-user-plus"></i>New contact</h2>
              <form className="pure-form">
                <fieldset className="pure-group">
                  <input type="text" className="pure-input-1-2" placeholder="First Name" value={this.state.firstName} onChange={this.handleFirstName} required />
                  <input type="text" className="pure-input-1-2" placeholder="Last Name" value={this.state.lastName} onChange={this.handleLastName} required />
                  <input type="text" className="pure-input-1-2" placeholder="Phone" value={this.state.phone} onChange={this.handlePhone} required />
                </fieldset>
                <button onClick={this.handleAdd} type="submit" className="pure-button pure-input-1-2 pure-button-primary">
                  <i className="fa fa-user-plus"></i>Add</button>
              </form>
            </div>
          </div>
          <div className="pure-u-sm-1 pure-u-1-3">
            <div className="box">
              <h2><i className="fa fa-search"></i>Search contact</h2>
              <form className="pure-form">
                <fieldset className="pure-group">
                  <input type="text" className="pure-input-1-2" value={this.state.searchTerm} onChange={this.handleSearchInput} />
                </fieldset>
                <button onClick={this.handleSearch} type="submit" className="pure-button pure-input-1-2 pure-button-primary">
                  <i className="fa fa-search"></i>Search</button>
              </form>
              {this.state.searchResult.length > 0 && (
                <table className="pure-table">
                <thead>
                  <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Phone</th>
                  </tr>
                </thead>

                <tbody>
                  {this.state.searchResult.map(contact => (
                    <tr key={contact.id}>
                      <td>{contact.firstName}</td>
                      <td>{contact.lastName}</td>
                      <td>{contact.phone}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
              )}
            </div>
          </div>
          <div className="pure-u-sm-1 pure-u-1-3">
            <div className="box">
              <h2><i className="fa fa-users"></i> Contacts</h2>
              <table className="pure-table">
                <thead>
                  <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Phone</th>
                  </tr>
                </thead>

                <tbody>
                  {this.state.contacts.map(contact => (
                    <tr key={contact.id}>
                      <td>{contact.firstName}</td>
                      <td>{contact.lastName}</td>
                      <td>{contact.phone}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    );
  }

}
export default App;
