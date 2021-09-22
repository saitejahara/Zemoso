import { BrowserRouter } from "react-router-dom";
import MyLibraryPage from "./MyLibraryPage";

export default {
  title: "My Library Page",
  component: MyLibraryPage,
};

export const MyLibraryDemo = () => (
  <BrowserRouter>
    {" "}
    <MyLibraryPage />
  </BrowserRouter>
);
