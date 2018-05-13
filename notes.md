##### Right now the form below submits to a missing route in the app. To complete the exercise, do the following:

- [ ] Create the missing /search route
    - [x] add `/search` to app `routes`
    - [x] add library to make HTTP calls
    - [x] test get for my addy
- [ ] Ingest the incoming form parameters
    - [ ] lower-casing the state abbreviation and appending it to ocd-division/country:us/state:
    - [ ] creating a copy of the state OCD-ID
    - [ ] appending /place: to it
    - [ ] lower-casing the city value, replacing all spaces with underscores, and appending it to that.
- [ ] Derive a basic set of OCD-IDs from the address (see below for further explanation)
- [ ] Retrieve upcoming elections from the Democracy Works election API using those OCD-IDs
- [ ] Display any matching elections to the user


##### You will get bonus points for:

- Documenting your code
- Adding tests for your code
- Standardizing and/or augmenting the address data to derive more OCD division IDs (e.g. county and legislative districts)
- Noting additional features or other improvements you would make if you had more time