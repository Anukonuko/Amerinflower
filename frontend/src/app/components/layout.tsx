import Header from "src/app/components/header";
import Main   from "src/app/components/main"
import Footer from "src/app/components/footer";
import React from "react";

type LayoutProps = {
  children: React.ReactNode;
};

export default function Layout({ children }: LayoutProps) {
  return (
    <>
      <Header />
      <Footer />
    </>
  );
}
