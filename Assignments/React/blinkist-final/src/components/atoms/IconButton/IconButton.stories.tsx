import SearchIcon from "@material-ui/icons/Search";
import IconButton from "./IconButton";

export default {
  title: "IconButton",
  component: IconButton,
};

export const SearchIconComponent = () => (
  <IconButton
    color="primary"
    disabled={false}
    icon={<SearchIcon fontSize="medium" />}
  ></IconButton>
);
