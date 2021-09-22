import { BrowserRouter } from "react-router-dom";
import Header from "./Header";

export default {
  title: "Header",
  component: Header,
};

export const HeaderDemo = () => (
  <BrowserRouter>
    <Header />
  </BrowserRouter>
);
