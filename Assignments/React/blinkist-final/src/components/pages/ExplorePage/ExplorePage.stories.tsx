import ExplorePage from "./ExplorePage";
import { BrowserRouter } from "react-router-dom";

export default {
  title: "Explore Page",
  component: ExplorePage,
};

export const ExplorePageDemo = () => (
  <BrowserRouter>
    {" "}
    <ExplorePage />{" "}
  </BrowserRouter>
);
