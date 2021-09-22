import React from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
// import My
import ExplorePage from "../components/pages/ExplorePage/ExplorePage";
import MyLibraryPage from "../components/pages/MyLibraryPage/MyLibraryPage";
// import PrivateRoute from "./private-routes";

const routes = () => {
  return (
    <div>
      <Switch>
        <Route path="/explore" exact component={ExplorePage}></Route>
        <Route path="/" exact component={ExplorePage}></Route>
        <Route path="/library" exact component={MyLibraryPage}></Route>
      </Switch>
    </div>
  );
};

export default routes;
