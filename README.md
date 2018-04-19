This project demonstrates the integration of spring/webservices/web3j with the ethereum world.
At the heart of this is a solidity contract for a decentralised auction. The contract is exposed completely exposed via webservices.
You can start as early as deploying the contract from the webservice. Note:This app supports only one contract deploy per vm,
as the contract address is cached after the first deploy.
After the contract is deployed an auction can be started and biding  via webservice. The test client demonstrates this.
You could also use any rest client to test this out.
This app has been tested with infura on rinkeby. But a local client should also work.

For more info on web3j refer to :https://docs.web3j.io/getting_started.html